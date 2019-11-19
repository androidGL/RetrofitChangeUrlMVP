package com.gl.retrofitchangeurlmvp.contract;

import com.gl.retrofitchangeurlmvp.base.IView;
import com.gl.retrofitchangeurlmvp.entity.NetResponse;
import com.gl.retrofitchangeurlmvp.entity.UserInfo;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * @Author: gl
 * @CreateDate: 2019/11/15
 * @Description:
 */
public interface MainContract {
    interface Model{
        String getdata();
        DisposableSingleObserver<NetResponse<UserInfo>> login(String s, DisposableSingleObserver<NetResponse<UserInfo>> observer);
    }
    interface View extends IView{
        String getParam();
        void updateView(UserInfo userInfo);
    }

    interface Presenter{
        void login();
        void getdata();
    }
}
