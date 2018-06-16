package net.skycrown.cuteassistant.network;

import net.skycrown.cuteassistant.network.ApiService.MusicApiService;

/**
 * Created by skycrown on 2018/6/10.
 * 获取对应的APIService
 */

public class RetrofitHelper {
    private static final String MUSIC_URL = "";
    private static MusicApiService sMusicApiService;

    public static MusicApiService getMusicApiService() {
        if (sMusicApiService == null) {
            sMusicApiService = RetrofitManager.INSTANCE.newRetrofit(MUSIC_URL).create(MusicApiService.class);
        }
        return sMusicApiService;
    }

}
