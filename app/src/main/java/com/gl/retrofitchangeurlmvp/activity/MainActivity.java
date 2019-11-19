package com.gl.retrofitchangeurlmvp.activity;

import android.view.View;
import android.widget.TextView;
import com.gl.retrofitchangeurlmvp.R;
import com.gl.retrofitchangeurlmvp.base.SimpleBaseActivity;
import com.gl.retrofitchangeurlmvp.contract.MainContract;
import com.gl.retrofitchangeurlmvp.entity.UserInfo;
import com.gl.retrofitchangeurlmvp.presenter.MainPresenter;

/**
 * 继承SimpleBaseActivity<MainPresenter>，则bindPresenter则为MainPresenter类型（因为父类是泛型）
 * 实现MainContract约束文件中的View接口
 */
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

    //返回的是MainPresenter类型presenter，并绑定
    @Override
    protected MainPresenter bindPresenter() {
        return new MainPresenter((MainContract.View) getSelfActivity());
    }

    @Override
    public String getParam() {
        return "李白";
    }

    //更新View，不许考虑网络请求、数据处理等其他的事儿，只要更新好view就好
    @Override
    public void updateView(UserInfo userInfo) {
        infoView.setText(userInfo.toString());
    }

    //界面按钮的点击方法，在xml文件中定义的
    public void get(View view) {
        //调用presenter层的login方法，开始进行网络请求啦
        presenter.login();
    }
}
