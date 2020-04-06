package com.wangzhen.saturation;

import android.app.Activity;
import android.app.Application;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.wangzhen.saturation.provider.ContextProvider;

/**
 * change color saturation of app.
 * Created by wangzhen on 2020/4/3.
 */
public final class ColorSaturation {
    private static ColorSaturation sInstance;

    static {
        sInstance = new ColorSaturation();
    }

    private ColorSaturation() {

    }

    /**
     * init color saturation, apply color saturation to each activity
     *
     * @param saturation saturation
     */
    public static void init(final float saturation) {
        ((Application) ContextProvider.sContext).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                sInstance.applyView(activity.getWindow().getDecorView(), saturation);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    /**
     * apply color saturation to given view
     *
     * @param view       view
     * @param saturation saturation
     */
    public static void apply(View view, float saturation) {
        sInstance.applyView(view, saturation);
    }

    /**
     * apply color saturation to given view
     *
     * @param view       view
     * @param saturation saturation
     */
    private void applyView(View view, float saturation) {
        if (view == null || saturation < 0) {
            return;
        }
        view.setLayerType(View.LAYER_TYPE_HARDWARE, createPaint(saturation));
    }


    /**
     * create paint
     *
     * @param saturation saturation
     * @return paint
     */
    private Paint createPaint(float saturation) {
        Paint paint = new Paint();
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(saturation);
        paint.setColorFilter(new ColorMatrixColorFilter(matrix));
        return paint;
    }
}
