package net.skycrown.cuteassistant.imageloader;

/**
 * Created by skycrown on 2018/6/13.
 */

public class ImageLoaderOptions {
    public static final int CENTER_CROP = 0;
    public static final int FIT_CENTER = 1;
    private int placeHolder = -1;
    private int errorDrawable = -1;
    private int cropType = CENTER_CROP;
    private boolean crossFade = false;
    private int crossDuration = 200;
    private boolean skipMemoryCache = false;
    private OverrideSize overrideSize = null;
    private boolean cropToCircle = false;
    private boolean grayScale = false;
    private BlurTransform blurTransform = null;
    private RoundedCornerTransform roundedCornerTransform = null;
    private ColorFilterTransform colorFilterTransform = null;


    public ImageLoaderOptions() {
        this(new Builder());
    }

    ImageLoaderOptions(Builder builder) {
        this.placeHolder = builder.placeHolder;
        this.errorDrawable = builder.errorDrawable;
        this.crossFade = builder.isCrossFade;
        this.crossDuration = builder.crossDuration;
        this.cropType = builder.cropType;
        this.skipMemoryCache = builder.skipMemoryCache;
        this.overrideSize = builder.overrideSize;
        this.cropToCircle = builder.cropToCircle;
        this.grayScale = builder.grayScale;
        this.blurTransform = builder.blurTransform;
        this.roundedCornerTransform = builder.roundedCornerTransform;
        this.colorFilterTransform = builder.colorFilterTransform;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public int getErrorDrawable() {
        return errorDrawable;
    }


    public boolean isCrossFade() {
        return crossFade;
    }

    public int getCrossDuration() {
        return crossDuration;
    }

    public int getCropType() {
        return cropType;
    }

    public boolean isSkipMemoryCache() {
        return skipMemoryCache;
    }

    public boolean isCropToCircle() {
        return cropToCircle;
    }

    public OverrideSize getOverrideSize() {
        return overrideSize;
    }

    public boolean isGrayScale() {
        return grayScale;
    }

    public BlurTransform getBlurTransform() {
        return blurTransform;
    }

    public RoundedCornerTransform getRoundedCornerTransform() {
        return roundedCornerTransform;
    }

    public ColorFilterTransform getColorFilterTransform() {
        return colorFilterTransform;
    }

    public static final class Builder {
        private int placeHolder = -1;
        private int errorDrawable = -1;
        private boolean isCrossFade = false;
        private int crossDuration = 200;
        private int cropType = CENTER_CROP;
        private boolean skipMemoryCache = false;
        private OverrideSize overrideSize = null;
        private boolean cropToCircle = false;
        private boolean grayScale = false;
        private BlurTransform blurTransform = null;
        private RoundedCornerTransform roundedCornerTransform = null;
        private ColorFilterTransform colorFilterTransform = null;


        public Builder setPlaceHolder(int placeHolder) {
            this.placeHolder = placeHolder;
            return this;
        }


        public void setErrorDrawable(int errorDrawable) {
            this.errorDrawable = errorDrawable;
        }


        public Builder setCrossFade(boolean crossFade) {
            this.isCrossFade = crossFade;
            return this;
        }

        public void setCrossDuration(int crossDuration) {
            this.crossDuration = crossDuration;
        }

        public void setCropType(int cropType) {
            this.cropType = cropType;
        }

        public Builder skipMemoryCache(boolean skipMemoryCache) {
            this.skipMemoryCache = skipMemoryCache;
            return this;
        }

        public void cropToCircle(boolean cropToCircle) {
            this.cropToCircle = cropToCircle;
        }

        public void setGrayScale(boolean grayScale) {
            this.grayScale = grayScale;
        }

        public void setSkipMemoryCache(boolean skipMemoryCache) {
            this.skipMemoryCache = skipMemoryCache;
        }

        public void setOverrideSize(OverrideSize overrideSize) {
            this.overrideSize = overrideSize;
        }


        public void setBlurTransform(BlurTransform blurTransform) {
            this.blurTransform = blurTransform;
        }

        public void setRoundedCornerTransform(RoundedCornerTransform roundedCornerTransform) {
            this.roundedCornerTransform = roundedCornerTransform;
        }

        public void setColorFilterTransform(ColorFilterTransform colorFilterTransform) {
            this.colorFilterTransform = colorFilterTransform;
        }

        public ImageLoaderOptions build() {
            return new ImageLoaderOptions(this);
        }

    }

    public static class OverrideSize {
        public int width = -1;
        public int height = -1;

        public OverrideSize(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public static class BlurTransform {
        public int radius = 25;

        public BlurTransform(int radius) {
            this.radius = radius;
        }

    }

    public static class RoundedCornerTransform {
        public int radius = 25;
        public int margin = 25;

        public RoundedCornerTransform(int radius, int margin) {
            this.radius = radius;
            this.margin = margin;
        }
    }

    public static class ColorFilterTransform {
        public int color;

        public ColorFilterTransform(int color) {
            this.color = color;
        }
    }

}
