package com.ty.dagger2project.model;


/**
 * 用于页面布局的文字赋值
 * Created by Lavender on 2018/1/11.
 */

public class TerminalModel {
    private String title;

    public TerminalModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
