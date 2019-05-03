package com.db.loan.loancenter.bean;

import java.io.Serializable;

/**
 * app启动信息
 * <p>
 * Created by hch on 2018/9/28.
 */

public class StartInfoBean implements Serializable {
    private String pkgName;
    private String h5Url;

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }
}
