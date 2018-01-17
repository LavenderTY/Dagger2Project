package com.ty.dagger2project.app;

import android.app.Application;
import android.databinding.DataBindingComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Lavender on 2018/1/12.
 */

@Singleton
@Component(modules = AppDataBindingModule.class)
public interface AppDataBindingComponent extends DataBindingComponent {

    @Component.Builder
    interface Builder {

        AppDataBindingComponent build();

        @BindsInstance
        Builder application(Application application);
    }
}