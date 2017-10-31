package net.skycrown.cuteassistant.base;

import android.app.Application;

/**
 * @author skycrown
 *
 */

public class MainApplication extends Application{
    // 单例
    private static MainApplication sInstance;

    public MainApplication getInstance() {
        if (sInstance == null) {
            sInstance = new MainApplication();
        }

        return sInstance;
    }



    @Override
    public void onCreate() {
        super.onCreate();
    }
}
