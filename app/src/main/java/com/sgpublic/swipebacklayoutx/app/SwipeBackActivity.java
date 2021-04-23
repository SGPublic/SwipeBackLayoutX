
package com.sgpublic.swipebacklayoutx.app;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import com.sgpublic.swipebacklayoutx.SwipeBackLayoutX;
import com.sgpublic.swipebacklayoutx.Utils;

public class SwipeBackActivity extends AppCompatActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    /**
     * @deprecated Use the <a href="https://developer.android.com/topic/libraries/view-binding">view-binding</a> instead.
     */
    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    public <T extends View> T findViewById(@IdRes int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return (T) mHelper.findViewById(id);
        return (T) v;
    }

    @Override
    public SwipeBackLayoutX getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
