package com.view.recycler.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.view.recycler.R;
import com.yline.base.BaseFragment;
import com.yline.view.recycler.adapter.AbstractHeadFootRecyclerAdapter;
import com.yline.view.recycler.decoration.CommonLinearDecoration;
import com.yline.view.recycler.holder.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class LinearFragment extends BaseFragment {
    private AbstractHeadFootRecyclerAdapter<String> mHeadFootRecyclerAdapter;

    public static LinearFragment newInstance() {
        return new LinearFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_linear, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mHeadFootRecyclerAdapter = new AbstractHeadFootRecyclerAdapter<String>() {
            @Override
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                holder.setText(R.id.tv_num, getItem(position));
            }

            @Override
            public int getItemRes() {
                return R.layout.item_recycler;
            }
        };

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_linear);
        recyclerView.setAdapter(mHeadFootRecyclerAdapter);
        recyclerView.addItemDecoration(new CommonLinearDecoration(getContext()) {
            @Override
            protected int getDivideResourceId() {
                return R.drawable.widget_recycler_divider_white_small;
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add("fucker - " + i);
        }
        mHeadFootRecyclerAdapter.setDataList(dataList, true);

        mHeadFootRecyclerAdapter.addHeadView(LayoutInflater.from(getContext()).inflate(R.layout.item_attach, null));
        mHeadFootRecyclerAdapter.addHeadView(LayoutInflater.from(getContext()).inflate(R.layout.item_attach, null));
        mHeadFootRecyclerAdapter.addFootView(LayoutInflater.from(getContext()).inflate(R.layout.item_attach, null));
        mHeadFootRecyclerAdapter.addFootView(LayoutInflater.from(getContext()).inflate(R.layout.item_attach, null));
    }
}
