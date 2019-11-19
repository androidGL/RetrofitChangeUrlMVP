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
    //先生成一个Model对象
    private MainContract.Model model;
    public MainPresenter(MainContract.View view) {
        super(view);
        model = new MainModel();
    }
    @Override
    public void login() {
        //处理数据
        DisposableSingleObserver<NetResponse<UserInfo>> disposableSingleObserver = new DisposableSingleObserver<NetResponse<UserInfo>>(){

            @Override
            public void onSuccess(NetResponse<UserInfo> value) {
                //如果网络请求返回的状态码为1，则让View层更新View
                if (value.getStatus() == 1)
                    getView().updateView(value.getData());
            }

            @Override
            public void onError(Throwable e) {

            }
        };
        //防止内存泄漏，所以统一管理，在destory时销毁
        addDisposable(disposableSingleObserver);
        //看！调用View层的获取参数的方法，拿到返回值传给M层进行网络请求,这就是桥梁啊
        model.login(getView().getParam(),disposableSingleObserver);
    }
}
