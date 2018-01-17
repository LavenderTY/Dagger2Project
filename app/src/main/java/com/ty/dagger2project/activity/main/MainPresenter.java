package com.ty.dagger2project.activity.main;

import com.ty.dagger2project.R;
import com.ty.dagger2project.app.AppManager;
import com.ty.dagger2project.base.BasePresenterImpl;
import com.ty.dagger2project.model.MainModel;
import com.ty.dagger2project.scope.ActivityScope;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Lavender on 2018/1/11.
 */
@ActivityScope
public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {
    private List<String> mList = new ArrayList<>();
    private List<Integer> mViewList = new ArrayList<>();
    private MainModel mainModel;

    @Inject
    public MainPresenter() {
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515059112717&di=3df6ee5c01605e689b69e1d39bdd0d30&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F011a0f5718b9096ac7254fbc11d4ad.jpg%40900w_1l_2o_100sh.jpg");
        mList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=665572007,3535031712&fm=27&gp=0.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515653872&di=387d172acbfc676e348bcffe9b85c26f&imgtype=jpg&er=1&src=http%3A%2F%2Fzjnews.zjol.com.cn%2Fmaterial%2Fg20gongshang%2Fshoujigsbanner.jpg");
        mList.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1294763344,4118733882&fm=27&gp=0.jpg");

        mViewList.add(R.layout.main_one);
        mViewList.add(R.layout.main_two);
        mViewList.add(R.layout.main_three);
        mainModel = new MainModel(mViewList, mList);
    }

    public MainModel getMainModel() {
        return mainModel;
    }

    @Override
    public void onViewAdded(MainContract.View view) {
        super.onViewAdded(view);
        getView().setModel(mainModel);
    }
}
