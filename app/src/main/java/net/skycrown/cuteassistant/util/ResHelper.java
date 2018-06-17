package net.skycrown.cuteassistant.util;

import android.graphics.drawable.Drawable;

import net.skycrown.cuteassistant.base.MainApplication;

/**
 * Created by skycrown on 2018/6/17.
 */

public class ResHelper {

    public static String getString(int resId) {
        return MainApplication.getInstance().getResources().getString(resId);
    }

    public static String getString(int resId, Object... formatArgs) {
        return MainApplication.getInstance().getResources().getString(resId, formatArgs);
    }

    public static int getColor(int resId) {
        return MainApplication.getInstance().getResources().getColor(resId);
    }

    public static Drawable getDrawable(int resId) {
        return MainApplication.getInstance().getResources().getDrawable(resId);
    }

    // 返回float型px，精确
    public static float getDimension(int resId) {
        return MainApplication.getInstance().getResources().getDimension(resId);
    }

    // 返回int型px，直接把小数部分去掉
    public static int getDimensionPixelOffset(int resId) {
        return MainApplication.getInstance().getResources().getDimensionPixelOffset(resId);
    }

    // 返回int型px，进行四舍五入
    public static int getDimensionPixelSize(int resId) {
        return MainApplication.getInstance().getResources().getDimensionPixelSize(resId);
    }

}
