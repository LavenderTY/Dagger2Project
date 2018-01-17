package com.ty.dagger2project.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;
import com.ty.dagger2project.BR;

import javax.inject.Inject;

/**
 * Created by Lavender on 2018/1/11.
 */

public class MainModel extends BaseObservable {
    private List<Integer> layoutList;
    private List<String> bannerList;

    public MainModel() {
    }

    public MainModel(List<Integer> layoutList, List<String> bannerList) {
        this.layoutList = layoutList;
        this.bannerList = bannerList;
    }

    @Bindable
    public List<Integer> getLayoutList() {
        return layoutList;
    }

    public void setLayoutList(List<Integer> layoutList) {
        this.layoutList = layoutList;
        notifyPropertyChanged(BR.layoutList);
    }

    @Bindable
    public List<String> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<String> bannerList) {
        this.bannerList = bannerList;
        notifyPropertyChanged(BR.bannerList);
    }
}
