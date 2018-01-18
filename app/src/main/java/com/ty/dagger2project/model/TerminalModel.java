package com.ty.dagger2project.model;


/**
 * 用于页面布局的文字赋值
 * Created by Lavender on 2018/1/11.
 */

public class TerminalModel {
    private String title;
    private int position;

    public TerminalModel(String title, int position) {
        this.title = title;
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "TerminalModel{" +
                "title='" + title + '\'' +
                ", position=" + position +
                '}';
    }
}
