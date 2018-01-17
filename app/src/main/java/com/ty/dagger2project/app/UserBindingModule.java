package com.ty.dagger2project.app;

import com.ty.dagger2project.activity.terminal.TerminalManagementActivity;
import com.ty.dagger2project.activity.terminal.TerminalModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by garimajain on 13/08/17.
 */
@Module
public abstract class UserBindingModule {

    @ContributesAndroidInjector(modules = {TerminalModule.class})
    abstract TerminalManagementActivity managementActivity();
}
