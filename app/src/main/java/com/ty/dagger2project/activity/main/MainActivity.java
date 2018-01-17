package com.ty.dagger2project.activity.main;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;

import com.tmall.ultraviewpager.IUltraIndicatorBuilder;
import com.tmall.ultraviewpager.UltraViewPager;
import com.ty.dagger2project.R;
import com.ty.dagger2project.adapter.UltraPagerAdapter;
import com.ty.dagger2project.base.BaseActivity;
import com.ty.dagger2project.databinding.ActivityMainBinding;
import com.ty.dagger2project.model.MainModel;
import com.ty.dagger2project.util.GlideImageLoader;
import com.youth.banner.listener.OnBannerListener;


import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View, OnBannerListener {
    private ActivityMainBinding binding;
    private IUltraIndicatorBuilder builder;
    @Inject
    UltraPagerAdapter adapter;
    @Inject
    UltraViewPager.ScrollMode scrollMode;
    @Inject
    GlideImageLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void OnBannerClick(int position) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        binding.banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        binding.banner.stopAutoPlay();
    }

    @Override
    public void setModel(MainModel mainModel) {
        binding.banner.setImages(mainModel.getBannerList())
                .setImageLoader(loader)
                .setOnBannerListener(this)
                .start();

        binding.ultraViewpager.setScrollMode(scrollMode);
        binding.ultraViewpager.setAdapter(adapter);
        binding.ultraViewpager.setInfiniteRatio(100);

        if (binding.ultraViewpager.getIndicator() == null) {
            binding.ultraViewpager.initIndicator();
            builder = binding.ultraViewpager.getIndicator();
            builder.setOrientation(UltraViewPager.Orientation.HORIZONTAL);
        }
        if (builder != null) {
            builder.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL)
                    //indicator的item之间的间距，默认是item的宽度
                    .setIndicatorPadding(20).setMargin(10, 10, 10, 10)
                    .setFocusColor(Color.BLUE).setNormalColor(Color.LTGRAY)
                    .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics())).build();
        }
    }
}
