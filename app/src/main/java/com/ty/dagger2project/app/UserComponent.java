package com.ty.dagger2project.app;

import com.ty.dagger2project.model.GetOrderRes;
import com.ty.dagger2project.scope.UserScope;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by garimajain on 13/08/17.
 */
@UserScope
@Subcomponent(modules = {UserBindingModule.class, AndroidSupportInjectionModule.class})
public interface UserComponent extends AndroidInjector<DaggerApplication> {
    void inject(AppManager appManager);

    @Subcomponent.Builder
    interface Builder {
        UserComponent build();
        @BindsInstance
        Builder getOrderRes(GetOrderRes res);
    }
}
