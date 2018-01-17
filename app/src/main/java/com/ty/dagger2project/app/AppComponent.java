package com.ty.dagger2project.app;

import android.app.Application;

import com.ty.dagger2project.MyApplication;
import com.ty.dagger2project.rxjava.ApiModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Lavender on 2018/1/11.
 * 声明Component，并添加依赖关系。
 * component是用来完成注入过程的一个桥梁，调用其inject()函数后即可完成注入。
 */
@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class,
        AppBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(MyApplication instance);

    @Component.Builder
    interface Builder {

        AppComponent build();

        @BindsInstance
        Builder application(Application application);
    }
}
