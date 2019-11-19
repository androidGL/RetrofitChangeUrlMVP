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
    public String getdata() {
        return null;
    }

    @Override
    public DisposableSingleObserver<NetResponse<UserInfo>> login(String s, DisposableSingleObserver<NetResponse<UserInfo>> observer) {
        RetrofitUrlManager.getInstance().putDomain(Api.URL_VALUE_SECOND,Api.BASEURL2);
        return RetrofitHelper.getInstance()
                .getRetrofit()
                .create(Api.class)
                .login(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(observer);

    }
}
