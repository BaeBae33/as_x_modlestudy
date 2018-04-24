package com.ndk;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ndk.jni.JniManager;
import com.ndk.jni.JniProvider;
import com.yline.test.BaseTestActivity;

/**
 * @author yline 2018/4/24 -- 10:16
 * @version 1.0.0
 */
public class MainActivity extends BaseTestActivity {
    private JniManager mJniManager;
    private JniProvider mJniProvider;

    @Override
    public void testStart(View view, Bundle savedInstanceState) {
        mJniManager = new JniManager();
        mJniProvider = new JniProvider();

        final TextView libTextView = addTextView("");
        addButton("stringFromJNI", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mJniManager.stringFromJNI();
                libTextView.setText(str);
            }
        });

        final TextView logTextView = addTextView("");
        addButton("logByJni", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logStr = mJniManager.logByJni("Android->JNI->Log");
                logTextView.setText(logStr);
            }
        });

        addButton("doProvider", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mJniProvider.doProvider();
            }
        });

        addButton("doStaticProvider", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mJniProvider.doStaticProvider();
            }
        });
    }
}
