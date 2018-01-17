package com.ty.dagger2project.base;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by Lavender on 2018/1/11.
 */

public interface BaseSchedulerProvider {
    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
