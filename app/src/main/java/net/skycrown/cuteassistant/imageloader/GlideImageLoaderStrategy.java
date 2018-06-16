package net.skycrown.cuteassistant.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by skycrown on 2018/6/13.
 */

public class GlideImageLoaderStrategy implements ImageLoaderStrategy {
    @Override
    public void loadImage(ImageView imageView, String url, ImageLoaderOptions options, ImageLoaderListener listener) {
        DrawableTypeRequest request = Glide.with(imageView.getContext()).load(url);
        loadOptions(imageView.getContext(), request, options, listener).into(imageView);
    }

    @Override
    public void loadImage(ImageView imageView, int resourceId, ImageLoaderOptions options, ImageLoaderListener listener) {
        DrawableTypeRequest request = Glide.with(imageView.getContext()).load(resourceId);
        loadOptions(imageView.getContext(), request, options, listener).into(imageView);
    }

    private DrawableTypeRequest loadOptions(Context context, DrawableTypeRequest request, ImageLoaderOptions options, final ImageLoaderListener listener) {
        if (options == null) {
            options = new ImageLoaderOptions(); // 使用默认值
        }

        if (options.getPlaceHolder() != -1) {
            request.placeholder(options.getPlaceHolder());
        }

        if (options.getErrorDrawable() != -1) {
            request.error(options.getPlaceHolder());
        }

        if (options.isCrossFade()) {
            request.crossFade(options.getCrossDuration());
        } else {
            request.dontAnimate();
        }

        if (options.getCropType() == ImageLoaderOptions.CENTER_CROP) {
            request.centerCrop();
        } else {
            request.fitCenter();
        }

        if (options.getOverrideSize() != null) {
            ImageLoaderOptions.OverrideSize size = options.getOverrideSize();
            if (size.width != -1 && size.height != -1) {
                request.override(size.width, size.height);
            }
        }

//         做一些转换
        ArrayList<Transformation<Bitmap>> transformationList = new ArrayList<>();

        if (options.isCropToCircle()) {
            transformationList.add(new CropCircleTransformation(context));
        }

        if (options.isGrayScale()) {
            transformationList.add(new GrayscaleTransformation(context));
        }

        if (options.getBlurTransform() != null) {
            transformationList.add(new BlurTransformation(context, options.getBlurTransform().radius));
        }

        if (options.getRoundedCornerTransform() != null) {
            ImageLoaderOptions.RoundedCornerTransform cornerTransform = options.getRoundedCornerTransform();
            transformationList.add(new RoundedCornersTransformation(context, cornerTransform.radius, cornerTransform.margin));
        }

        if (options.getColorFilterTransform() != null) {
            transformationList.add(new ColorFilterTransformation(context, options.getColorFilterTransform().color));
        }

        if (!transformationList.isEmpty()) {
            Transformation<Bitmap>[] transformArray = new Transformation[transformationList.size()];
            transformationList.toArray(transformArray);
            request.bitmapTransform(transformArray);
        }

        request.skipMemoryCache(options.isSkipMemoryCache());
        request.diskCacheStrategy(DiskCacheStrategy.ALL);

        if (listener != null) {
            request.listener(new RequestListener() {
                @Override
                public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
                    listener.onLoadError();
                    return false;
                }

                @Override
                public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache, boolean isFirstResource) {
                    listener.onLoadSuccess();
                    return false;
                }
            });
        }

        return request;
    }

    @Override
    public void clearMemoryCache(Context context) {
        Glide.get(context).clearMemory();
    }

    @Override
    public void clearDiskCache(Context context) {
        Glide.get(context).clearDiskCache();
    }

    @Override
    public void trimMemory(Context context, int level) {
        Glide.get(context).trimMemory(level);
    }
}
