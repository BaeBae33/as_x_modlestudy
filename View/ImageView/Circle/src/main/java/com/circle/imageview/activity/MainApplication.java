package com.circle.imageview.activity;

import com.yline.application.BaseApplication;
import com.yline.application.SDKConfig;

public class MainApplication extends BaseApplication
{
	public static final String TAG = "CircleImageView";

	@Override
	protected SDKConfig initConfig()
	{
		SDKConfig appConfig = new SDKConfig();
		appConfig.setLogFilePath("CircleImageView"); // 默认开启日志,并写到文件中
		return appConfig;
	}
}
