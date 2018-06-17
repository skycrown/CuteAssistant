package net.skycrown.cuteassistant.util;

import java.util.regex.Pattern;

/**
 * Created by skycrown on 2018/6/16.
 */

public class RegexUtil {

    public static boolean isMobile(CharSequence mobile) {
        String regex = "(\\+\\d+)?1[3458]\\d{9}$";
        return Pattern.matches(regex, mobile);
    }

    public static boolean isEmail(CharSequence email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    public static boolean isUrl(CharSequence url) {
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
        return Pattern.matches(regex, url);
    }
}
