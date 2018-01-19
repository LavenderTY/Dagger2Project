package com.ty.dagger2project.activity.login;

import com.ty.dagger2project.base.BasePresenter;
import com.ty.dagger2project.base.BaseView;
import com.ty.dagger2project.model.LoginModel;
import com.ty.dagger2project.model.MainModel;

/**
 * 主页面接口
 * Created by Lavender on 2018/1/11.
 */

public interface LoginContract {
    interface View extends BaseView {
        void setModel(LoginModel loginModel);
    }

    interface Presenter extends BasePresenter<View> {
        void onSubmitClick();
    }
}
