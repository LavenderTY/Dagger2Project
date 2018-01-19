package com.ty.dagger2project.model;

/**
 * Created by Lavender on 2018/1/11.
 */

public class GetOrderRes {
    private String phone;
    private String appid;
    private String amount;
    private String trans_type;
    private String mchnt_no;
    private String org_order_id;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public String getMchnt_no() {
        return mchnt_no;
    }

    public void setMchnt_no(String mchnt_no) {
        this.mchnt_no = mchnt_no;
    }

    public String getOrg_order_id() {
        return org_order_id;
    }

    public void setOrg_order_id(String org_order_id) {
        this.org_order_id = org_order_id;
    }
}
