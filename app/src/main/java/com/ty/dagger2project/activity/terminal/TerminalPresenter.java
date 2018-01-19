package com.ty.dagger2project.activity.terminal;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ty.dagger2project.activity.login.LoginActivity;
import com.ty.dagger2project.activity.TerminalQueryActivity;
import com.ty.dagger2project.base.BasePresenterImpl;
import com.ty.dagger2project.model.TerminalModel;
import com.ty.dagger2project.scope.ActivityScope;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Lavender on 2018/1/11.
 */
@ActivityScope
public class TerminalPresenter extends BasePresenterImpl<TerminalContract.View> implements TerminalContract.Presenter {
    private List<TerminalModel> mList = new ArrayList<>();

    @Inject
    public TerminalPresenter() {
        mList.add(new TerminalModel("终端登录", 0));
        mList.add(new TerminalModel("终端主密钥下载", 1));
        mList.add(new TerminalModel("终端参数查询", 2));
        mList.add(new TerminalModel("清除终端参数", 3));
    }

    public List<TerminalModel> getList() {
        return mList;
    }

    @Override
    public void onViewAdded(TerminalContract.View view) {
        super.onViewAdded(view);
        getView().setModel(mList);
    }

    public void onItemClick(View view, TerminalModel model) {
        int i = model.getPosition();
        Context context = view.getContext();
        switch (i) {
            case 0:
                context.startActivity(new Intent(context, LoginActivity.class));
                break;
            case 1:
                break;
            case 2:
                context.startActivity(new Intent(context, TerminalQueryActivity.class));
                break;
            case 3:
                break;
        }
    }
}
