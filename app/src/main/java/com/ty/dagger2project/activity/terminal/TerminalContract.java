package com.ty.dagger2project.activity.terminal;

import com.ty.dagger2project.base.BasePresenter;
import com.ty.dagger2project.base.BaseView;
import com.ty.dagger2project.model.MainModel;
import com.ty.dagger2project.model.TerminalModel;

import java.util.List;

/**
 * 主页面接口
 * Created by Lavender on 2018/1/11.
 */

public interface TerminalContract {
    interface View extends BaseView {
        void setModel(List<TerminalModel> list);
    }

    interface Presenter extends BasePresenter<View> {

    }
}
