package net.skycrown.cuteassistant.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by skycrown on 2018/6/16.
 */

public class SnackbarUtil {
    private static final int COLOR_INFO = 0xff31708f;
    private static final int COLOR_CONFIRM = 0xff3c763d;
    private static final int COLOR_WARNING = 0xff8a6d3b;
    private static final int COLOR_DANGER= 0xffa94442;
    private static final int ACTION_COLOR = 0xffCDC5BF;
    private Snackbar mSnackbar;

    public SnackbarUtil(Snackbar snackbar) {
        mSnackbar = snackbar;
    }

    public static SnackbarUtil makeShort(View view, String text) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        return new SnackbarUtil(snackbar);
    }

    public static SnackbarUtil makeLong(View view, String text) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        return new SnackbarUtil(snackbar);
    }

    private View getSnackbarLayout(Snackbar snackbar) {
        if (snackbar != null) {
            return snackbar.getView();
        }
        return null;
    }

    private Snackbar setSnackbarBackgroundColor(int colorId) {
        View snackbarView = getSnackbarLayout(mSnackbar);
        if (snackbarView != null) {
            snackbarView.setBackgroundColor(colorId);
        }

        return mSnackbar;
    }

    public void info() {
        setSnackbarBackgroundColor(COLOR_INFO);
        show();
    }

    public void info(String actionText, View.OnClickListener listener) {
        setSnackbarBackgroundColor(COLOR_INFO);
        show(actionText, listener);
    }

    public void confirm() {
        setSnackbarBackgroundColor(COLOR_CONFIRM);
        show();
    }

    public void confirm(String actionText, View.OnClickListener listener) {
        setSnackbarBackgroundColor(COLOR_CONFIRM);
        show(actionText, listener);
    }


    public void warning() {
        setSnackbarBackgroundColor(COLOR_WARNING);
        show();
    }

    public void warning(String actionText, View.OnClickListener listener) {
        setSnackbarBackgroundColor(COLOR_WARNING);
        show(actionText, listener);

    }

    public void danger() {
        setSnackbarBackgroundColor(COLOR_DANGER);
        show();
    }

    public void danger(String actionText, View.OnClickListener listener) {
        setSnackbarBackgroundColor(COLOR_DANGER);
        show(actionText, listener);
    }


    public void show() {
        mSnackbar.show();
    }

    public void show(String actionText, View.OnClickListener listener) {
        mSnackbar.setActionTextColor(ACTION_COLOR);
        mSnackbar.setAction(actionText, listener).show();
    }

}
