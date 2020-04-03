package com.wangzhen.saturation.demo;

import android.app.Application;

import com.wangzhen.saturation.ColorSaturation;
import com.wangzhen.saturation.type.SaturationScale;

/**
 * BaseApplication
 * Created by wangzhen on 2020/4/3.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ColorSaturation.init(SaturationScale.GRAY);
    }
}
