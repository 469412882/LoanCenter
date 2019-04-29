package com.db.loan.loancenter.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yofish.kitmodule.base_component.webview.BaseWebActivity;

/**
 * file description
 * <p>
 * Created by hch on 2019/4/29.
 */
public class MainWebViewActivity extends BaseWebActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbar().setVisibility(View.GONE);
    }

    @Override
    protected void initConfig() {
        super.initConfig();
        setFullScreenFlag(false);
    }
}
