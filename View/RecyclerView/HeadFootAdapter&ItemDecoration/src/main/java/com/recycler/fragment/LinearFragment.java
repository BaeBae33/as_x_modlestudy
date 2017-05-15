package com.recycler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recycler.R;
import com.yline.base.BaseFragment;
import com.yline.view.apply.SimpleLinearItemDecoration;
import com.yline.view.common.HeadFootRecyclerAdapter;
import com.yline.view.common.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class LinearFragment extends BaseFragment
{
	private HeadFootRecyclerAdapter headFootRecyclerAdapter;

	public static LinearFragment newInstance()
	{
		return new LinearFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_linear, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		headFootRecyclerAdapter = new HeadFootRecyclerAdapter<String>()
		{
			@Override
			public int getItemRes()
			{
				return R.layout.item_recycler;
			}

			@Override
			public void setViewContent(RecyclerViewHolder holder, int position)
			{
				holder.setText(R.id.tv_num, sList.get(position));
			}
		};

		RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_linear);
		recyclerView.setAdapter(headFootRecyclerAdapter);
		recyclerView.addItemDecoration(new SimpleLinearItemDecoration(getContext())
		{
			@Override
			protected int getHeadNumber()
			{
				return 2;
			}

			@Override
			protected int getFootNumber()
			{
				return 2;
			}

			@Override
			protected int getDivideResourceId()
			{
				return R.drawable.widget_recycler_divider_white_small;
			}
		});
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

		List<String> dataList = new ArrayList<>();
		for (int i = 0; i < 20; i++)
		{
			dataList.add("fucker - " + i);
		}
		headFootRecyclerAdapter.setDataList(dataList);

		headFootRecyclerAdapter.addHeadView(LayoutInflater.from(getContext()).inflate(R.layout.item_attach, null));
		headFootRecyclerAdapter.addHeadView(LayoutInflater.from(getContext()).inflate(R.layout.item_attach, null));
		headFootRecyclerAdapter.addFootView(LayoutInflater.from(getContext()).inflate(R.layout.item_attach, null));
		headFootRecyclerAdapter.addFootView(LayoutInflater.from(getContext()).inflate(R.layout.item_attach, null));
	}
}
