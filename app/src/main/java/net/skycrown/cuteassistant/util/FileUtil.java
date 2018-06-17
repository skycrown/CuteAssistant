package net.skycrown.cuteassistant.util;

import android.os.Environment;

import java.io.File;

/**
 * Created by skycrown on 2018/6/16.
 */

public class FileUtil {

    public static File getFileByPath(final String filePath) {
        return isSpace(filePath) ? null : new File(filePath);
    }

    public static boolean isSDCardEnable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    public static String getSDCardPath() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return null;
    }

    private static boolean isSpace(final String str) {
        if (str == null) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}
