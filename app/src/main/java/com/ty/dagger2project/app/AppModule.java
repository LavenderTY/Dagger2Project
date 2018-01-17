package com.ty.dagger2project.app;

import com.ty.dagger2project.base.BaseSchedulerProvider;
import com.ty.dagger2project.rxjava.SchedulerProvider;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Lavender on 2018/1/11.
 */
@Module
public abstract class AppModule {
    @Binds
    abstract BaseSchedulerProvider providerSchedulerProvider(SchedulerProvider provider);
}
