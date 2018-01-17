package com.ty.dagger2project.activity.terminal;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.ty.dagger2project.adapter.TerminalManagementAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lavender on 2018/1/12.
 *
 * @BInds注解可以用来代替@Provides，被@Binds注解的方法返回该方法参数，被@Binds注解的方法必须是抽象的。
 */
@Module
public class TerminalModule {
    @Provides
    public TerminalContract.Presenter provideTerminalPresenter(TerminalPresenter presenter) {
        return presenter;
    }

    @Provides
    public TerminalManagementAdapter provideTerminalManagementAdapter(TerminalManagementActivity activity, TerminalPresenter presenter) {
        return new TerminalManagementAdapter(activity, presenter.getList());
    }

    @Provides
    public LinearLayoutManager provideLayoutManager(TerminalManagementActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    public DividerItemDecoration provideDividerItemDecoration(TerminalManagementActivity activity) {
        return new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL);
    }
}


