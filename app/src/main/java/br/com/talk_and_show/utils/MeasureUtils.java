package br.com.talk_and_show.utils;

import android.content.Context;

public class MeasureUtils {
    public static float convertDpToPx(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public static float convertPxToDp(Context context, float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }
}
