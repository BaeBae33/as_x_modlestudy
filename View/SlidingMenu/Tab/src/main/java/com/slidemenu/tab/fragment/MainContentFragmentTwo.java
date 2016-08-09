package com.slidemenu.tab.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.view.slidingmenu.tab.R;
import com.yline.base.BaseFragment;

public class MainContentFragmentTwo extends BaseFragment
{
	private View mViewTwo;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		mViewTwo = inflater.inflate(R.layout.fragment_content_two, container, false);
		return mViewTwo;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
	}

}
