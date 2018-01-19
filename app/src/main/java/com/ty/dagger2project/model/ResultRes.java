package com.ty.dagger2project.model;

/**
 * Created by Lavender on 2018/1/19.
 */

public class ResultRes extends GetOrderRes{
    private String return_msg;
    private String return_code;
    private String order_id;

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "ResultRes{" +
                "return_msg='" + return_msg + '\'' +
                ", return_code='" + return_code + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
