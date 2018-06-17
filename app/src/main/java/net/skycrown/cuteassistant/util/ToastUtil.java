package net.skycrown.cuteassistant.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import net.skycrown.cuteassistant.base.MainApplication;

/**
 * Created by skycrown on 2018/6/16.
 */

public class ToastUtil {
    private static final int MSG_SHOW_TOAST = 0;
    private static Toast mToast = null;
    private static Handler sHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            if (mToast != null) {
                mToast.cancel();
            }

            String message = (String) msg.obj;
            mToast = Toast.makeText(MainApplication.getInstance(), message, msg.arg1);
            mToast.show();
        }
    };

    public static void show(String message, int duration) {
        Message msg = sHandler.obtainMessage(MSG_SHOW_TOAST);
        msg.obj = message;
        msg.arg1 = duration;
        sHandler.sendMessage(msg);
    }

    public static void show(String message) {
        if (!TextUtils.isEmpty(message)) {
            show(message, Toast.LENGTH_SHORT);
        }
    }

}
