package com.ty.dagger2project.activity.terminal;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.ty.dagger2project.R;
import com.ty.dagger2project.adapter.TerminalManagementAdapter;
import com.ty.dagger2project.base.BaseUserActivity;
import com.ty.dagger2project.databinding.ActivityTerminalManagementBinding;
import com.ty.dagger2project.model.TerminalModel;
import com.ty.dagger2project.util.SetToolBarUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * 终端管理
 */
public class TerminalManagementActivity extends BaseUserActivity<TerminalContract.Presenter> implements TerminalContract.View{
    private ActivityTerminalManagementBinding binding;
    @Inject
    LinearLayoutManager manager;
    @Inject
    DividerItemDecoration decoration;
    @Inject
    TerminalManagementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_terminal_management);
        super.onCreate(savedInstanceState);
        SetToolBarUtil.initToolbar(this, binding.llTitle.toolbar,R.string.terminal_management);
    }

    @Override
    public void setModel(List<TerminalModel> list) {
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(manager);
        binding.recyclerView.addItemDecoration(decoration);
        binding.recyclerView.setAdapter(adapter);
    }
}
