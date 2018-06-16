package net.skycrown.cuteassistant.imageloader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by skycrown on 2018/6/12.
 */

public enum ImageLoader {
    INSTANCE;

    private ImageLoaderStrategy mStrategy;

    ImageLoader() {
        mStrategy = new GlideImageLoaderStrategy();
    }

    public void loadImage(ImageView imageView, String url) {
        this.loadImage(imageView, url, null, null);
    }

    public void loadImage(ImageView imageView, String url, ImageLoaderOptions options) {
        this.loadImage(imageView, url, options, null);
    }

    public void loadImage(ImageView imageView, String url, ImageLoaderListener listener) {
        this.loadImage(imageView, url, null, listener);
    }

    public void loadImage(ImageView imageView, String url,ImageLoaderOptions options, ImageLoaderListener listener) {
        mStrategy.loadImage(imageView, url, options, listener);
    }

    public void loadImage(ImageView imageView, int resourceId) {
        this.loadImage(imageView, resourceId, null, null);
    }

    public void loadImage(ImageView imageView, int resourceId, ImageLoaderOptions options) {
        this.loadImage(imageView, resourceId, options, null);
    }

    public void loadImage(ImageView imageView, int resourceId, ImageLoaderListener listener) {
        this.loadImage(imageView, resourceId, null, listener);
    }

    public void loadImage(ImageView imageView, int resourceId,  ImageLoaderOptions options, ImageLoaderListener listener) {
        mStrategy.loadImage(imageView,  resourceId,options, listener);
    }


    public void clearMemoryCache(Context context) {
        mStrategy.clearMemoryCache(context);
    }

    public void clearDiskCache(Context context) {
        mStrategy.clearDiskCache(context);
    }


    public void trimMemory(Context context, int level) {
        mStrategy.trimMemory(context, level);
    }
}
