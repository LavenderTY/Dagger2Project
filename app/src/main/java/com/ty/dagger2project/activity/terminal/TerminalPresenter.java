package com.ty.dagger2project.activity.terminal;

import com.ty.dagger2project.app.AppManager;
import com.ty.dagger2project.base.BasePresenterImpl;
import com.ty.dagger2project.model.TerminalModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Lavender on 2018/1/11.
 */
public class TerminalPresenter extends BasePresenterImpl<TerminalContract.View> implements TerminalContract.Presenter {
    private List<TerminalModel> mList;

    @Inject
    public TerminalPresenter(AppManager manager) {
        mList.add(new TerminalModel("终端登录"));
        mList.add(new TerminalModel("终端主密钥下载"));
        mList.add(new TerminalModel("终端参数查询"));
        mList.add(new TerminalModel("清除终端参数"));
    }

    public List<TerminalModel> getList() {
        return mList;
    }

    @Override
    public void onViewAdded(TerminalContract.View view) {
        super.onViewAdded(view);
        getView().setModel(mList);
    }
}
