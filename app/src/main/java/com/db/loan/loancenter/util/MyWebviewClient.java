package com.db.loan.loancenter.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;

import com.tencent.smtt.sdk.WebView;
import com.yofish.kitmodule.base_component.webview.DefaultWebViewClient;

public class MyWebviewClient extends DefaultWebViewClient {
    public MyWebviewClient(Context context) {
        super(context);
    }

    @Override
    public void onPageStarted(WebView webView, String url, Bitmap bitmap) {
        {
            try {
                if (url.startsWith("weixin://wap/pay?")) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    webView.getContext().startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
                //调起微信页面失败,自己看着办...
            }
            super.onPageStarted(webView, url, bitmap);
        }
    }
}