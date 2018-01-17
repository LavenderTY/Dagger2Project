package com.ty.dagger2project.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ty.dagger2project.app.AppManager;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by garimajain on 18/08/17.
 */

public abstract class BaseUserActivity<T extends BasePresenter> extends BaseActivity<T> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void androidInject() {
        AndroidInjection.inject(this);
    }
}
