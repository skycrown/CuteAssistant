package net.skycrown.cuteassistant.util;

import android.util.Log;

import net.skycrown.cuteassistant.BuildConfig;

/**
 * Created by wjd on 2018/6/10.
 * 日志打印工具类
 */

public final class LogUtil {
    private static final String TAG = "CuteAssistant";

    public static void v(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, buildMsg(tag, msg));
        }
    }

    public static void v(String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, buildMsg(tag, msg));
        }
    }

    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, buildMsg(tag, msg));
        }
    }

    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, buildMsg(tag, msg));
        }
    }

    public static void w(String msg) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        Log.e(TAG, buildMsg(tag, msg));
    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    private static String buildMsg(String tag, String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append('[')
                .append(tag)
                .append(']')
                .append(' ')
                .append(msg);
        return  builder.toString();
    }
}
