package com.example.muhoitem1.utils;

import android.widget.Toast;

import com.example.muhoitem1.base.BaseApplication;

public class ToastUtils {

    private static Toast mToast;

    public static void showToast(String tips) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getAppContext(), tips, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(tips);
        }
        mToast.show();
    }
}
