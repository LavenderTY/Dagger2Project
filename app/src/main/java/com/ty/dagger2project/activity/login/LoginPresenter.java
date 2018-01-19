package com.ty.dagger2project.activity.login;

import android.util.Log;

import com.ty.dagger2project.app.AppManager;
import com.ty.dagger2project.base.BasePresenterImpl;
import com.ty.dagger2project.base.BaseSchedulerProvider;
import com.ty.dagger2project.scope.ActivityScope;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * 没有搞定
 * Created by Lavender on 2018/1/11.
 */
@ActivityScope
public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {
    private final AppManager appManager;
    private final BaseSchedulerProvider schedulerProvider;
    private Map<String, Object> sendMap = new HashMap<>();


    @Inject
    public LoginPresenter(AppManager appManager, BaseSchedulerProvider schedulerProvider) {
        this.appManager = appManager;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public void onViewAdded(LoginContract.View view) {
        super.onViewAdded(view);
        sendMap.put("phone", "1100089701");
        sendMap.put("amount", "9600");
        sendMap.put("trans_type", "01");
        sendMap.put("mchnt_no", "309041189120276");
        sendMap.put("org_order_id", "18011900309480");
    }


    @Override
    public void onSubmitClick() {
        Disposable disposable = appManager.login(sendMap)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doFinally(() -> {
                })
                .subscribe(getOrderRes -> {
                    getView().showMessage("Login Successful");
                }, throwable -> {
                    throwable.printStackTrace();
                    getView().showMessage(throwable.getMessage());
                });
        compositeDisposable.add(disposable);
    }
}
