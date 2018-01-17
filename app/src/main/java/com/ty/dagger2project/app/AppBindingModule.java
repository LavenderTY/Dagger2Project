package com.ty.dagger2project.app;

import com.ty.dagger2project.activity.main.MainActivity;
import com.ty.dagger2project.activity.main.MainModule;
import com.ty.dagger2project.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Lavender on 2018/1/12.
 */
@Module(subcomponents = UserComponent.class)
public abstract class AppBindingModule {

    // 该注解在Module里使用，与@Binds一样，被@ContributesAndroidInjector注解的方法必须是抽象的,
    // 返回的是一个具体的android组件，方法不应该有参数。该注解会为android组件生成subcomponent，
    // 而不需要像之前那样自己实现@Subcomponent。如：
    @ContributesAndroidInjector(modules = MainModule.class)
    @ActivityScope
    abstract MainActivity mainActivity();
}
