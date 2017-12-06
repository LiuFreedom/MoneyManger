package com.ly.moneymanage.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.ly.moneymanage.di.module.WelcomeModule;

import com.ly.moneymanage.mvp.ui.activity.WelcomeActivity;

@ActivityScope
@Component(modules = WelcomeModule.class, dependencies = AppComponent.class)
public interface WelcomeComponent {
    void inject(WelcomeActivity activity);
}