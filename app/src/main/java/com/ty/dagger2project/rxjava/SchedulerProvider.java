package com.ty.dagger2project.rxjava;

import android.support.annotation.NonNull;

import com.ty.dagger2project.base.BaseSchedulerProvider;

import javax.inject.Inject;

import dagger.Reusable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lavender on 2018/1/11.
 * @Reusable绑定，不像其他的Scope——它不和任何单独的component关联，而是实际使用绑定的component缓存返回或初始化的实例。
 * 如果你在组件中引入一个有@Reusable绑定的模块，但是只有一个子组件实际用到这个绑定，那么只有这个
 * 子组件会缓存这个绑定。如果共享祖先的两个子组件各自使用到这个绑定，那它们各自都会缓存自己的对象。
 * 如果一个组件的祖先已经缓存了这个对象，子组件会直接使用它。因为无法保证组件只会调用这个绑定一次，
 * 所以应用@Reusable到返回易变对象的绑定中，或者必须要使用相同实例的对象上，是很危险的。
 * 如果不用关心实例化次数的话，在unscope对象上用@Reusable是安全的。
 */
@Reusable
public class SchedulerProvider implements BaseSchedulerProvider {

    @Inject
    public SchedulerProvider() {

    }

    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
