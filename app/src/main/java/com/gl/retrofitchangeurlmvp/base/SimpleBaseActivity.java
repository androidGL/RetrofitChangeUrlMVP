package com.gl.retrofitchangeurlmvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public abstract class SimpleBaseActivity<P extends IPresenter> extends Activity implements IView{
    protected P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(getLayoutId());
        presenter = bindPresenter();
        start();
    }
    //abstract类中带有abstract标记的方法必须由子类继承并重新
    public abstract int getLayoutId();
    // 绑定Presenter
    protected abstract P bindPresenter();

    //开始了,子类可以在这个方法初始化view或其他初始化工作
    public void start(){

    }

    @Override
    public Activity getSelfActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null)
            presenter.detachView();
    }

}
