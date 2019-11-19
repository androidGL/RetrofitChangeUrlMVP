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
        /**
         * Model层负责处理登陆的网络请求
         * @param name 需要传的参数
         * @param observer 在presenter层传来的，负责处理数据的逻辑
         */
        void login(String name, DisposableSingleObserver<NetResponse<UserInfo>> observer);
    }
    interface View extends IView{
        //获取参数，也就是Model层login方法需要的name
        String getParam();

        /**
         * 更新View，由Presenter处理数据后调用
         * @param userInfo
         */
        void updateView(UserInfo userInfo);
    }

    interface Presenter{
        //Model层和View层的桥梁，负责处理数据逻辑
        void login();
    }
}
