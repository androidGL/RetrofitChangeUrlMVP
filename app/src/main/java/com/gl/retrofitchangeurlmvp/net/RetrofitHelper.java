package com.gl.retrofitchangeurlmvp.net;

import android.util.Log;

import com.gl.retrofitchangeurlmvp.net.url.RetrofitUrlManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.Protocol.HTTP_1_1;

/**
 * @Author: gl
 * @CreateDate: 2019/10/30
 * @Description:
 */
public class RetrofitHelper {
    private static volatile RetrofitHelper instance;
    private final Retrofit retrofit;
    private static final int READ_TIMEOUT = 12;//读取超时时间（秒）
    private static final int CONN_TIMEOUT = 12;//连接超时时间（秒）

    private HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            showLog("retrofitBack = " + message);
        }
    });


    private RetrofitHelper() {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.BASEURL)
                .client(RetrofitUrlManager.getInstance()
                        .with(new OkHttpClient().newBuilder())
                        .addInterceptor(loggingInterceptor)
                        .addInterceptor(new simulateResponse())
                        .connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .build())
                .build();
    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitHelper.class) {
                if (instance == null) {
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private void showLog(String msg) {
        Log.i(getClass().getName(), msg);
    }
    //模拟响应拦截器
    private class simulateResponse implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            final HttpUrl url = request.url();//获取路径
            //判断是否需要拦截
            String apiNname = NetTest.isExist(url.toString());
            if(null != apiNname){
                String responseContent = NetTest.getVisualResponseByApi(apiNname);
                return new Response.Builder()
                        .code(200)
                        .message("模拟响应")
                        .body(ResponseBody.create(MediaType.parse("UTF-8"),responseContent))
                        .request(request)
                        .protocol(HTTP_1_1)
                        .build();
            }
            return chain.proceed(request);
        }
    }

}
