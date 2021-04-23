package com.sgpublic.swipebacklayoutx.app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.sgpublic.swipebacklayoutx.R;
import com.sgpublic.swipebacklayoutx.SwipeBackLayoutX;

/**
 * @author Yrom
 */
public class SwipeBackActivityHelper {
    private final Activity mActivity;

    private SwipeBackLayoutX mSwipeBackLayout;

    public SwipeBackActivityHelper(Activity activity) {
        mActivity = activity;
    }

    @SuppressWarnings("deprecation")
    public void onActivityCreate() {
        mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mActivity.getWindow().getDecorView().setBackgroundDrawable(null);
        mSwipeBackLayout = (SwipeBackLayoutX) LayoutInflater.from(mActivity).inflate(R.layout.swipeback_layout, null);
    }

    public void onPostCreate() {
        mSwipeBackLayout.attachToActivity(mActivity);
    }

    public View findViewById(int id) {
        if (mSwipeBackLayout != null) {
            return mSwipeBackLayout.findViewById(id);
        }
        return null;
    }

    public SwipeBackLayoutX getSwipeBackLayout() {
        return mSwipeBackLayout;
    }
}
