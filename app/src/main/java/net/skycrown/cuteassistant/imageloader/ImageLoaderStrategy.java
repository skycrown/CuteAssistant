package net.skycrown.cuteassistant.imageloader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by skycrown on 2018/6/13.
 * 图片加载策略类
 */

public interface ImageLoaderStrategy {
    void loadImage(ImageView imageView, String url, ImageLoaderOptions options, ImageLoaderListener listener);

    void loadImage(ImageView imageView, int resourceId, ImageLoaderOptions options, ImageLoaderListener listener);

    void clearMemoryCache(Context context);

    void clearDiskCache(Context context);

    void trimMemory(Context context, int level);
}
