package com.sdcard.activity;

import com.sdcard.R;
import com.sdcard.utils.SDCardUtil;
import com.yline.base.BaseActivity;
import com.yline.log.LogFileUtil;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity
{
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btn_sdcard).setOnClickListener(new View.OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                LogFileUtil.v(MainApplication.TAG, "onClick -> btn_sdcard");
                
                LogFileUtil.i(MainApplication.TAG, "SDCardUtil.isSDCardEnable() = " + SDCardUtil.isSDCardEnable());
                
                LogFileUtil.i(MainApplication.TAG,
                    "SDCardUtil.getRootDirectoryPath() = " + SDCardUtil.getRootDirectoryPath());
                LogFileUtil.i(MainApplication.TAG, "SDCardUtil.getSDCardPath() = " + SDCardUtil.getSDCardPath());
                
                LogFileUtil.i(MainApplication.TAG,
                    "SDCardUtil.getSDCardAvailableSize() = "
                        + SDCardUtil.getSDCardAvailableSize() * 1.0f / (1024 * 1024 * 1024));
                LogFileUtil.i(MainApplication.TAG,
                    "SDCardUtil.getSDCardBlockSize() = "
                        + SDCardUtil.getSDCardBlockSize() * 1.0f / (1024 * 1024 * 1024));
                
            }
        });
    }
    
}
