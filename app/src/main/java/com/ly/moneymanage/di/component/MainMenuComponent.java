package com.ly.moneymanage.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.ly.moneymanage.di.module.MainMenuModule;

import com.ly.moneymanage.mvp.ui.activity.MainMenuActivity;

@ActivityScope
@Component(modules = MainMenuModule.class, dependencies = AppComponent.class)
public interface MainMenuComponent {
    void inject(MainMenuActivity activity);
}