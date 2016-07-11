package com.aidl.activity;

import com.yline.application.AppConfig;
import com.yline.application.BaseApplication;

import android.os.Message;

public class MainApplication extends BaseApplication
{
    public static final String TAG = "aidl";
    
    @Override
    protected void handlerDefault(Message msg)
    {
        
    }
    
    @Override
    protected AppConfig initConfig()
    {
        AppConfig appConfig = new AppConfig();
        appConfig.setFileLogPath("aidl"); // 默认开启日志,并写到文件中
        return appConfig;
    }
}
