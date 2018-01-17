package com.ty.dagger2project.base;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.ty.dagger2project.R;

/**
 * Created by Lavender on 2018/1/16.
 */

public class BaseBindingViewHolder extends BaseViewHolder {
    public BaseBindingViewHolder(View view) {
        super(view);
    }

    public ViewDataBinding getBinding() {
        return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
    }
}
