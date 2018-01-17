package com.ty.dagger2project.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ty.dagger2project.app.AppManager;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Lavender on 2018/1/5.
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView,
        HasSupportFragmentInjector {

    public T getPresenter() {
        return presenter;
    }

    @Inject
    AppManager appManager;

    @Inject
    DispatchingAndroidInjector<Fragment> injector;

    @Inject
    T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        androidInject();
        super.onCreate(savedInstanceState);
        presenter.onViewAdded(this);
        appManager.setInjector();
    }

    protected void androidInject() {
        // Dagger2.Android 的注入方式
        AndroidInjection.inject(this);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.onViewRemoved();
        super.onDestroy();
    }

    @Override
    public void finishView() {

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return injector;
    }

}
