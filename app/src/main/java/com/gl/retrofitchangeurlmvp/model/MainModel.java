package com.gl.retrofitchangeurlmvp.model;

import com.gl.retrofitchangeurlmvp.contract.MainContract;
import com.gl.retrofitchangeurlmvp.entity.NetResponse;
import com.gl.retrofitchangeurlmvp.entity.UserInfo;
import com.gl.retrofitchangeurlmvp.net.Api;
import com.gl.retrofitchangeurlmvp.net.RetrofitHelper;
import com.gl.retrofitchangeurlmvp.net.url.RetrofitUrlManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author: gl
 * @CreateDate: 2019/11/15
 * @Description:
 */
public class MainModel implements MainContract.Model {

    @Override
    public void login(String s, DisposableSingleObserver<NetResponse<UserInfo>> observer) {
        //下面这行主要是用来修改baseURL的，如果不需要可以不加的
        //第一个参数表示要修改哪个网络请求的BaseURL，第二个参数表示要修改成什么样的URL
        RetrofitUrlManager.getInstance().putDomain(Api.URL_VALUE_SECOND, Api.BASEURL2);
        RetrofitHelper.getInstance()
                .getRetrofit()
                .create(Api.class)
                .login(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(observer);

    }
}
