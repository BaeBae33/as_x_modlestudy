package com.dm.singleton.enums;

import com.dm.singleton.activity.MainApplication;
import com.yline.log.LogFileUtil;

/**
 * 即使反序列化,也不会重新生成对象
 */
public enum SingletonEnum
{
    INSTANCE;
    
    public void doSome()
    {
        LogFileUtil.i(MainApplication.TAG, "SingletonEnum -> doSome");
    }
}
