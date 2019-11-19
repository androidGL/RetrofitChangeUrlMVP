package com.gl.retrofitchangeurlmvp.net;


import com.gl.retrofitchangeurlmvp.entity.NetResponse;
import com.gl.retrofitchangeurlmvp.entity.UserInfo;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    //成员变量,默认修饰符 public static final
    //成员方法,默认修饰符 public abstract
    String BASEURL = "https://api.apiopen.top";//测试api
    String BASEURL2 = "https://api.apiopen.second";//测试api，错误的

    //header中添加 URL_KEY，表示这个请求是需要替换BaseUrl的
    String URL_KEY = "URL_KEY";
    //header中的value值，用于区分需要替换的BaseUrl是哪一个
    String URL_VALUE_SECOND = "URL_VALUE_SECOND";
    //这儿添加Headers是为了修改BaseURL的，key用于识别是不是需要修改BaseURL，value用来识别需要修改哪个BaseURL
    //使用时只需要在网络请求前添加： RetrofitUrlManager.getInstance().putDomain(Api.URL_VALUE_SECOND,"https://new.address.com");
    @Headers({URL_KEY+":"+URL_VALUE_SECOND})
    @POST("login")
    Single<NetResponse<UserInfo>> login(@Query("name") String key);


    @GET("novelSearchApi")
    Observable<ResponseBody> getCall2(@Query("name") String ip);//测试+Rxjava


    @POST("searchAuthors")
    Single<ResponseBody> test(@Query("name") String base64);
    @POST("sug")
    @FormUrlEncoded
    Observable<ResponseBody> getCallPost(@Field("q") String q, @Field("code") String code);
}
