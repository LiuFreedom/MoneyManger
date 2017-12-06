package com.ly.moneymanage.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import com.ly.moneymanage.di.component.DaggerWelcomeComponent;
import com.ly.moneymanage.di.module.WelcomeModule;
import com.ly.moneymanage.mvp.contract.WelcomeContract;
import com.ly.moneymanage.mvp.presenter.WelcomePresenter;

import com.ly.moneymanage.R;


import static com.jess.arms.utils.Preconditions.checkNotNull;


public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerWelcomeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .welcomeModule(new WelcomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_welcome; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


}
