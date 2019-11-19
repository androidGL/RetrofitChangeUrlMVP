package com.gl.retrofitchangeurlmvp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.gl.retrofitchangeurlmvp.R;
import com.gl.retrofitchangeurlmvp.base.IPresenter;
import com.gl.retrofitchangeurlmvp.base.SimpleBaseActivity;
import com.gl.retrofitchangeurlmvp.contract.MainContract;
import com.gl.retrofitchangeurlmvp.entity.UserInfo;
import com.gl.retrofitchangeurlmvp.presenter.MainPresenter;

public class MainActivity extends SimpleBaseActivity<MainPresenter> implements MainContract.View {

    private TextView infoView;

    @Override
    public void start() {
        super.start();
        infoView = findViewById(R.id.info);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter bindPresenter() {
        return new MainPresenter((MainContract.View) getSelfActivity());
    }

    @Override
    public String getParam() {
        return "李白";
    }

    @Override
    public void updateView(UserInfo userInfo) {
        infoView.setText(userInfo.toString());
    }

    public void get(View view) {
        presenter.login();
    }
}
