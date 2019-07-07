package com.db.loan.loancenter.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.db.loan.loancenter.util.MyWebviewClient;
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
        setStatusBarHintDarkGEM(true);
    }

    /**
     * 设置状态栏的文字颜色
     *
     * @param darkcolor true : 设置为白色文字， false ： 设置为灰色文字
     */
    public void setStatusBarHintDarkGEM(boolean darkcolor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView = this.getWindow().getDecorView();
            int flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            if (darkcolor) {
                flag |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }

            decorView.setSystemUiVisibility(flag);
        }

    }

    @Override
    public void setWebViewClient() {
        getWebView().setWebViewClient(new MyWebviewClient(this));
    }
}
