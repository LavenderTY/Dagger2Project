package com.ty.dagger2project;

import android.app.Activity;
import android.app.Application;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;

import com.ty.dagger2project.app.AppComponent;
import com.ty.dagger2project.app.AppManager;
import com.ty.dagger2project.app.DaggerAppComponent;
import com.ty.dagger2project.app.DaggerAppDataBindingComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * AndroidInjector<T>:注入Android库的类型的接口, T为Android库的基本类型T,比如Activity、Fragment、BroadcastReceive等；
 * DispatchingAndroidInjector<T>:其为AndroidInjector<T>接口的实现类，将Android核心库的的基本类型T的实例注入Dagger，该操作是由Android核心库的类的实例本身执行，而不是Dagger。
 * Created by Lavender on 2018/1/11.
 */

public class MyApplication extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    @Inject
    AppManager appManager;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //设置一个DataBinding 的Component
        DataBindingUtil.setDefaultComponent(buildDataBindingComponent());
        createComponent();
    }

    protected void createComponent() {
        //AppComponent 与 DahakaApplication 绑定
        appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
    }

    private DataBindingComponent buildDataBindingComponent() {
        //得到DataBindingComponent 对象
        return DaggerAppDataBindingComponent.builder().application(this).build();
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return appManager.activityInjector();
    }
}
