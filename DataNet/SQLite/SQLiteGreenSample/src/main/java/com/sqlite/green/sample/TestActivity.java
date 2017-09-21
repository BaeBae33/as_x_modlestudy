package com.sqlite.green.sample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sqlite.green.SQLiteManager;
import com.sqlite.green.test.NetCacheModel;
import com.yline.log.LogFileUtil;
import com.yline.test.BaseTestActivity;
import com.yline.utils.LogUtil;

import java.util.Arrays;
import java.util.List;

public class TestActivity extends BaseTestActivity {
    public static void launcher(Context context) {
        if (null != context) {
            Intent intent = new Intent(context, TestActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            context.startActivity(intent);
        }
    }

    private String url = "1234567890";

    @Override
    public void testStart(View view, Bundle savedInstanceState) {
        addButton("insert", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SampleModel save = new SampleModel();
                long rowId = SQLiteManager.insertOrReplace(new NetCacheModel(url, save));
                LogUtil.v("rowId = " + rowId);
            }
        });

        addButton("读取", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SampleModel result = SQLiteManager.load(url, SampleModel.class);
                if (null == result){
                    LogFileUtil.v("result is null");
                }else {
                    LogFileUtil.v("result = " + result.toString());
                }
            }
        });
    }

    private class SampleModel {
        private String test;

        private List<String> list;

        public SampleModel() {
            this.test = "123";
            this.list = Arrays.asList("A", "B", "C", "D", "E");
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "SampleModel{" +
                    "test='" + test + '\'' +
                    ", list=" + list +
                    '}';
        }
    }
}
