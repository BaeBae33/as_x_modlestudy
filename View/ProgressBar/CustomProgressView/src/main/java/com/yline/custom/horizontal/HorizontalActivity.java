package com.yline.custom.horizontal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.yline.base.BaseActivity;

public class HorizontalActivity extends BaseActivity{
	public static void launch(Context context){
		if (null != context){
			Intent intent = new Intent();
			intent.setClass(context, HorizontalActivity.class);
			if (!(context instanceof Activity)){
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			}
			context.startActivity(intent);
		}
	}
}
