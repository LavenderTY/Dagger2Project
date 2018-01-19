package com.ty.dagger2project.activity.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.ty.dagger2project.R;
import com.ty.dagger2project.base.BaseUserActivity;
import com.ty.dagger2project.databinding.ActivityLoginBinding;
import com.ty.dagger2project.model.LoginModel;
import com.ty.dagger2project.util.SetToolBarUtil;

public class LoginActivity extends BaseUserActivity<LoginContract.Presenter> implements LoginContract.View {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        SetToolBarUtil.initToolbar(this, binding.loginToolbar.toolbar, R.string.terminal_management);
        binding.setPresenter(getPresenter());
    }

    @Override
    public void setModel(LoginModel model) {

    }
}
