package com.yline.custom.system;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yline.base.BaseActivity;
import com.yline.custom.R;

public class SystemActivity extends BaseActivity {
	
	public static void launch(Context context){
		if (null != context){
			Intent intent = new Intent();
			intent.setClass(context, SystemActivity.class);
			if (!(context instanceof Activity)){
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			}
			context.startActivity(intent);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system);
	}
}
