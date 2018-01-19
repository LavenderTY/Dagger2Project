package com.ty.dagger2project.activity.login;

import dagger.Binds;
import dagger.Module;
/**
 * Created by Lavender on 2018/1/12.
 *
 * @BInds注解可以用来代替@Provides，被@Binds注解的方法返回该方法参数，被@Binds注解的方法必须是抽象的。
 */
@Module
public abstract class LoginModule {

    @Binds
    public abstract LoginContract.Presenter provideLoginPresenter(LoginPresenter loginPresenter);
}


