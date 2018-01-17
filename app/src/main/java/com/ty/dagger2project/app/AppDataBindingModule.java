package com.ty.dagger2project.app;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lavender on 2018/1/12.
 */
@Module
public class AppDataBindingModule {
    @Provides
    @Singleton
    public RequestManager provideGlideRequestManager(Application application) {
        return Glide.with(application);
    }
}
