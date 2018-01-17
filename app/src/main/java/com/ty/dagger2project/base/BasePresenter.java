package com.ty.dagger2project.base;

/**
 * Created by Lavender on 2018/1/11.
 */

public interface BasePresenter<T extends BaseView> {
    //添加View
    void onViewAdded(T view);

    //删除View
    void onViewRemoved();
}