package com.view.design.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.view.design.R;
import com.yline.base.BaseFragment;

/**
 * @author yline 2017/2/24 --> 13:58
 * @version 1.0.0
 */
public class DeleteFragment2 extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_delete, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_light));
        ((TextView) view.findViewById(android.R.id.text1)).setText(this.getClass().getSimpleName());
    }
}
