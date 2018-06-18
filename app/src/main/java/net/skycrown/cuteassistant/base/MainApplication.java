package net.skycrown.cuteassistant.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * @author skycrown
 *
 */

public class MainApplication extends Application{
    // 单例
    private static MainApplication sInstance = null;

    public static MainApplication getInstance() {
        return sInstance;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
