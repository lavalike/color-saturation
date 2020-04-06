package com.wangzhen.saturation.demo

import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.wangzhen.saturation.ColorSaturation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkbox_all.setOnCheckedChangeListener(this)
        checkbox_image.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (buttonView == checkbox_all) {
            ColorSaturation.apply(
                window.decorView, if (isChecked) {
                    0f
                } else {
                    1f
                }
            )
        }
        if (buttonView == checkbox_image) {
            ColorSaturation.apply(
                imageView, if (isChecked) {
                    0f
                } else {
                    1f
                }
            )
        }
    }
}
