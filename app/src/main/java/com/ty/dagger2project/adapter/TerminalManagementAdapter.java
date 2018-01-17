package com.ty.dagger2project.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ty.dagger2project.R;
import com.ty.dagger2project.activity.LoginActivity;
import com.ty.dagger2project.activity.TerminalQueryActivity;
import com.ty.dagger2project.base.BaseBindingViewHolder;
import com.ty.dagger2project.databinding.ItemTerminalBinding;
import com.ty.dagger2project.model.TerminalModel;

import java.util.List;

/**
 * Created by Lavender on 2018/1/11.
 */

public class TerminalManagementAdapter extends BaseQuickAdapter<TerminalModel, BaseBindingViewHolder> implements AdapterView.OnItemClickListener {
    private Context context;
    private ItemTerminalBinding binding;

    public TerminalManagementAdapter(Context context, List<TerminalModel> modelList) {
        super(R.layout.item_terminal, modelList);
        this.context = context;
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, TerminalModel item) {
        binding = (ItemTerminalBinding) helper.getBinding();
        binding.terminalTitle.setText(item.getTitle());
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
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
