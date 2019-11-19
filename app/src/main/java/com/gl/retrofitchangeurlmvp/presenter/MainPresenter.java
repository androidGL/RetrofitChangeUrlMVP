package com.gl.retrofitchangeurlmvp.presenter;

import com.gl.retrofitchangeurlmvp.base.BasePresenter;
import com.gl.retrofitchangeurlmvp.contract.MainContract;
import com.gl.retrofitchangeurlmvp.entity.NetResponse;
import com.gl.retrofitchangeurlmvp.entity.UserInfo;
import com.gl.retrofitchangeurlmvp.model.MainModel;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * @Author: gl
 * @CreateDate: 2019/11/15
 * @Description:
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private MainContract.Model model;
    public MainPresenter(MainContract.View view) {
        super(view);
        model = new MainModel();
    }

    @Override
    public void login() {
        DisposableSingleObserver<NetResponse<UserInfo>> disposableSingleObserver = new DisposableSingleObserver<NetResponse<UserInfo>>(){

            @Override
            public void onSuccess(NetResponse<UserInfo> value) {
                if (value.getStatus() == 1)
                    getView().updateView(value.getData());

            }

            @Override
            public void onError(Throwable e) {

            }
        };
        addDisposable(disposableSingleObserver);
        model.login(getView().getParam(),disposableSingleObserver);

    }

    @Override
    public void getdata() {

    }
}
