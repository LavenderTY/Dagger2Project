package com.ty.dagger2project.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ty.dagger2project.R;

/**
 * Created by Lavender on 2018/1/5.
 */

public class SetToolBarUtil {
    @SuppressLint("NewApi")
    public static void initToolbar(final AppCompatActivity activity, Toolbar toolbar, int title) {
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle(title);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }
}
