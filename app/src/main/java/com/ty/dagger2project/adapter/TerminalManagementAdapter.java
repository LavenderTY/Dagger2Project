package com.ty.dagger2project.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ty.dagger2project.R;
import com.ty.dagger2project.activity.terminal.TerminalPresenter;
import com.ty.dagger2project.base.BaseBindingViewHolder;
import com.ty.dagger2project.databinding.ItemTerminalBinding;
import com.ty.dagger2project.model.TerminalModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Lavender on 2018/1/11.
 */

public class TerminalManagementAdapter extends BaseQuickAdapter<TerminalModel, BaseBindingViewHolder> {
    private ItemTerminalBinding binding;
    private TerminalPresenter presenter;

    public TerminalManagementAdapter(TerminalPresenter presenter, List<TerminalModel> modelList) {
        super(R.layout.item_terminal, modelList);
        this.presenter = presenter;
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, TerminalModel item) {
        binding = (ItemTerminalBinding) helper.getBinding();
        binding.setTerminalModel(item);
        binding.setTerminalPresenter(presenter);
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }
}
