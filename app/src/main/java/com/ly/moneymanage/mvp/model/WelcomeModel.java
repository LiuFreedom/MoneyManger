package com.ly.moneymanage.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.ly.moneymanage.mvp.contract.WelcomeContract;


@ActivityScope
public class WelcomeModel extends BaseModel implements WelcomeContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public WelcomeModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}