package com.db.loan.loancenter;

import com.yofish.kitmodule.base_component.BaseApp;
import com.yofish.kitmodule.base_component.BaseKit;
import com.yofish.kitmodule.util.Utility;


/**
 * Created by hch on 2018/12/5.
 * Des application类 用于应用初始化操作
 */

public class App extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        String talingDataAppId = Utility.getMetaDataFromApp(getContext(), "TALKING_DATA_APP_ID");
        String umengKey = Utility.getMetaDataFromApp(getContext(), "UMENG_APPKEY");
        String channel = Utility.getMetaDataFromApp(getContext(), "UMENG_CHANNEL");
        String appMgr = Utility.getMetaDataFromApp(getContext(), "com.yofish.mall.appMgr");
        String sourceId = Utility.getMetaDataFromApp(getContext(), "com.yofish.mall.sourceId");
        BaseKit.init(this, appMgr, sourceId, BuildConfig.LOG_DEBUG, "myApp_data", talingDataAppId, umengKey, channel, "1");
    }

}
