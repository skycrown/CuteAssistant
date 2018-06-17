package net.skycrown.cuteassistant.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by skycrown on 2018/6/16.
 */

public class ScreenUtil {

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object obj = clazz.newInstance();
            Field field = clazz.getField("status_bar_height");
            int height = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelOffset(height);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    public static int getNavigationBarHeight(Context context) {
        Resources res = context.getResources();
        int identifier = res.getIdentifier("navigation_bar_height", "dimen", "android");
        return res.getDimensionPixelOffset(identifier);
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap bmp = decorView.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap snapShotBmp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        decorView.destroyDrawingCache();
        return snapShotBmp;
    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap bmp = decorView.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap snapShotBmp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
        decorView.destroyDrawingCache();
        return snapShotBmp;
    }


}
