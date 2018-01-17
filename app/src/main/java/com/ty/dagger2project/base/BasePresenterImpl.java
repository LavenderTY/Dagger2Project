package com.ty.dagger2project.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Lavender on 2018/1/11.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    //OkHttpClient加载图片给DisposableObserver，CompositeDisposable调度控制后台任务队列
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public T getView() {
        return view;
    }

    private T view;

    @Override
    public void onViewAdded(T view) {
        this.view = view;
    }

    @Override
    public void onViewRemoved() {
        //取消异步操作，防止内存泄漏（将所有的 observer 取消订阅）
        compositeDisposable.clear();
        view = null;
    }
}
