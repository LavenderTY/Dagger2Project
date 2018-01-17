package com.ty.dagger2project.activity.main;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.tmall.ultraviewpager.IUltraIndicatorBuilder;
import com.tmall.ultraviewpager.UltraViewPager;
import com.ty.dagger2project.adapter.UltraPagerAdapter;
import com.ty.dagger2project.model.MainModel;
import com.ty.dagger2project.util.GlideImageLoader;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lavender on 2018/1/12.
 *
 * @BInds注解可以用来代替@Provides，被@Binds注解的方法返回该方法参数，被@Binds注解的方法必须是抽象的。
 */
@Module
public class MainModule {
    @Provides
    public MainContract.Presenter provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }

    @Provides
    public UltraPagerAdapter provideUltraPagerAdapter(MainActivity activity, MainPresenter presenter) {
        return new UltraPagerAdapter(activity, presenter.getMainModel().getLayoutList());
    }

    @Provides
    public UltraViewPager.ScrollMode provideScrollMode() {
        return UltraViewPager.ScrollMode.HORIZONTAL;
    }

    @Provides
    public GlideImageLoader provideGlideImageLoader() {
        return new GlideImageLoader();
    }
}


