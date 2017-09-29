package com.imageview.plus.activity;

import android.os.Bundle;

import com.imageview.plus.PlusImageView;
import com.imageview.plus.R;
import com.yline.base.BaseActivity;

public class MainActivity extends BaseActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		PlusImageView imageView = (PlusImageView) findViewById(R.id.iv_item_app);
		imageView.setImageResource(R.drawable.test);
		imageView.setmType(2);
		imageView.setmRectRoundRadius(getResources().getDimensionPixelSize(R.dimen.rectRoundRadius));
	}
}
