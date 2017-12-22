package com.ly.moneymanage.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.ly.moneymanage.mvp.contract.MainMenuContract;
import com.ly.moneymanage.mvp.model.MainMenuModel;


@Module
public class MainMenuModule {
    private MainMenuContract.View view;

    /**
     * 构建MainMenuModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainMenuModule(MainMenuContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainMenuContract.View provideMainMenuView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainMenuContract.Model provideMainMenuModel(MainMenuModel model) {
        return model;
    }
}