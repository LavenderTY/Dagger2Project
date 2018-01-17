package com.ty.dagger2project.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ty.dagger2project.R;
import com.ty.dagger2project.activity.AuthorizationActivity;
import com.ty.dagger2project.activity.BalanceActivity;
import com.ty.dagger2project.activity.CardApplicationActivity;
import com.ty.dagger2project.activity.CardVouchersActivity;
import com.ty.dagger2project.activity.CashAccountActivity;
import com.ty.dagger2project.activity.CashierActivity;
import com.ty.dagger2project.activity.CheckBalanceActivity;
import com.ty.dagger2project.activity.ElectronicCashActivity;
import com.ty.dagger2project.activity.MoreActivity;
import com.ty.dagger2project.activity.PreferentialPurchaseActivity;
import com.ty.dagger2project.activity.ReceivablesActivity;
import com.ty.dagger2project.activity.RevokeActivity;
import com.ty.dagger2project.activity.terminal.TerminalManagementActivity;
import com.ty.dagger2project.activity.TransferActivity;
import com.ty.dagger2project.databinding.MainOneBinding;
import com.ty.dagger2project.databinding.MainThreeBinding;
import com.ty.dagger2project.databinding.MainTwoBinding;
import com.ty.dagger2project.listener.EventListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Lavender on 2018/1/4.
 */
public class UltraPagerAdapter extends PagerAdapter implements EventListener {
    private Context context;
    private List<Integer> mList;
    private LayoutInflater inflater;
    private Pools.Pool<View> pool = new Pools.SimplePool<>(4);

    @Inject
    public UltraPagerAdapter(Context context, List<Integer> mList) {
        this.context = context;
        this.mList = mList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = pool.acquire();
        if (view == null) {
            view = DataBindingUtil.inflate(inflater, mList.get(position), container, false).getRoot();
        }
        switch (position) {
            case 0:
                MainOneBinding oneBinding = DataBindingUtil.bind(view);
                oneBinding.setListener(this);
                break;
            case 1:
                MainTwoBinding twoBinding = DataBindingUtil.bind(view);
                twoBinding.setListener(this);
                break;
            case 2:
                MainThreeBinding threeBinding = DataBindingUtil.bind(view);
                threeBinding.setListener(this);
                break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
        pool.release(view);
    }

    @Override
    public void click(View view) {
        switch (view.getId()) {
            case R.id.ll_cashier:
                //收银
                context.startActivity(new Intent(context, CashierActivity.class));
                break;
            case R.id.ll_revoke:
                //撤销
                context.startActivity(new Intent(context, RevokeActivity.class));
                break;
            case R.id.ll_pre_authorization:
                //预授权
                context.startActivity(new Intent(context, AuthorizationActivity.class));
                break;
            case R.id.ll_back_goods:
                //退货
                context.startActivity(new Intent(context, RevokeActivity.class));
                break;
            case R.id.ll_receivables:
                //收款明细
                context.startActivity(new Intent(context, ReceivablesActivity.class));
                break;
            case R.id.ll_check_balance:
                //余额查询
                context.startActivity(new Intent(context, CheckBalanceActivity.class));
                break;
            case R.id.ll_cash_account:
                //现金记账
                context.startActivity(new Intent(context, CashAccountActivity.class));
                break;
            case R.id.ll_transfer:
                //转账
                context.startActivity(new Intent(context, TransferActivity.class));
                break;
            case R.id.ll_balance:
                //结算
                context.startActivity(new Intent(context, BalanceActivity.class));
                break;
            case R.id.ll_terminal_management:
                //终端管理
                context.startActivity(new Intent(context, TerminalManagementActivity.class));
                break;
            case R.id.ll_card_application:
                //信用卡申请
                context.startActivity(new Intent(context, CardApplicationActivity.class));
                break;
            case R.id.ll_card_vouchers:
                //卡券验核
                context.startActivity(new Intent(context, CardVouchersActivity.class));
                break;
            case R.id.ll_preferential_purchase:
                //优惠买单
                context.startActivity(new Intent(context, PreferentialPurchaseActivity.class));
                break;
            case R.id.ll_electronic_cash:
                //电子现金
                context.startActivity(new Intent(context, ElectronicCashActivity.class));
                break;
            case R.id.ll_more:
                //更多
                context.startActivity(new Intent(context, MoreActivity.class));
                break;
        }
    }
}
