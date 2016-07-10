package com.android.unit.context.test;

import com.yline.log.LogFileUtil;

import android.test.AndroidTestCase;

public class ContextTest extends AndroidTestCase
{
    private static final String TAG = "ContextTest";
    
    public void testContext()
    {
        assertNotNull(mContext);
        // 测试用例,在这里打印会被,重定向到LogCat中显示
        System.out.println("Context 测试");
        LogFileUtil.v(TAG, "Context 测试");
    }
}
