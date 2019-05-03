package com.db.loan.loancenter.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.db.loan.loancenter.R;
import com.db.loan.loancenter.bean.StartInfoBean;
import com.yofish.kitmodule.base_component.BaseActivity;
import com.yofish.kitmodule.util.AppSharedPrefrences;
import com.yofish.kitmodule.util.Constants;
import com.yofish.kitmodule.util.LogUtils;
import com.yofish.kitmodule.util.NetClient;
import com.yofish.kitmodule.util.Utility;
import com.yofish.kitmodule.wedget.CustomProgressBar;
import com.yofish.netmodule.callback.BaseCallBack;
import com.yofish.netmodule.datatype.AllJsonObject;

import java.util.List;


/**
 * 启动页
 * 1、首先加载启动静态图
 * 2、检查是否需要显示引导页 （优先级：GIF > 静态引导， 注意：静态引导需要修改INTRO_HASVIEWED_KEY 以改变引导页版本，GIF引导需要命名为def_intro.gif）
 * 3、检查是否需要显示广告页 （优先级：GIF > 静态广告）
 *
 * <p>
 * Created by hch on 2018/9/28.
 */

public class IntroActivity extends BaseActivity implements View.OnClickListener {

    /**
     * PUSH_KEY
     */
    public static final String PUSH_KEY = "push_key";
    /**
     * 第一个启动页的启动时间
     */
    private final int DEF_INTRO_TIME = 5 * 1000;
    /**
     * 启动页view
     */
    private ImageView introPageView;

    private String h5Url;

    @Override
    protected int setLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_intro;
    }

    @Override
    protected void initViews() {
        h5Url = AppSharedPrefrences.getInstance().get(com.db.loan.loancenter.util.Constants.H5_START_URL, "");
        if (TextUtils.isEmpty(h5Url)) {
            h5Url = Utility.getMetaDataFromApp(this, "H5_URL");
        }
        introPageView = (ImageView) findViewById(R.id.intro_image);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doNextIntro();
            }
        }, DEF_INTRO_TIME);
        loadStartInfo();
    }

    /**
     * 默认启动页启动后执行动作
     */
    private void doNextIntro() {
        LogUtils.i("doNextIntro");

        gotoMain("");
    }

    /**
     * 跳转到首页
     */
    private void gotoMain(String target) {
        if (isFinishing()) {
            return;
        }
        Intent intent = new Intent(IntroActivity.this, MainWebViewActivity.class);
        intent.putExtra(MainWebViewActivity.WEB_TITLE, "贷款超市");
        intent.putExtra(MainWebViewActivity.WEB_URL, h5Url);
        startActivity(intent);
        finish();
    }

    /**
     * 取启动信息
     */
    private void loadStartInfo() {
        NetClient.newBuilder(this).baseUrl("https://raw.githubusercontent.com/469412882/loan_center_interface/master/")
                .method("start.json").callBack(new BaseCallBack<List<StartInfoBean>>() {

            @Override
            public void onSuccess(List<StartInfoBean> startInfoBeanList) {
                if (startInfoBeanList == null) {
                    return;
                }
                String pkgname = Utility.getPackageName(IntroActivity.this);
                for (StartInfoBean bean : startInfoBeanList) {
                    if (pkgname.equals(bean.getPkgName())) {
                        AppSharedPrefrences.getInstance().put(com.db.loan.loancenter.util.Constants.H5_START_URL, bean.getH5Url());
                        h5Url = bean.getH5Url();
                        break;
                    }
                }
            }

            @Override
            public void onFailed(String code, String errors) {

            }
        }).sendGet();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skip_btn:
                gotoMain("");
                break;
        }
    }


}
