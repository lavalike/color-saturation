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
    private Paint mPaint;

    static {
        sInstance = new ColorSaturation();
    }

    private ColorSaturation() {

    }

    /**
     * init color saturation
     *
     * @param saturation saturation
     */
    public static void init(float saturation) {
        sInstance.apply(saturation);
    }

    /**
     * apply color saturation to each activity
     *
     * @param saturation saturation
     */
    private void apply(float saturation) {
        mPaint = new Paint();
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(saturation);
        mPaint.setColorFilter(new ColorMatrixColorFilter(matrix));
        ((Application) ContextProvider.sContext).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                activity.getWindow().getDecorView().setLayerType(View.LAYER_TYPE_HARDWARE, mPaint);
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
}
