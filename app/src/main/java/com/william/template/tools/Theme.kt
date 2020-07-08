package com.william.template.tools

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate.*

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */
enum class Theme(val mode: Int) {
    DARK(MODE_NIGHT_YES),
    LIGHT(MODE_NIGHT_NO),
    SYSTEM_DEFAULT(
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MODE_NIGHT_FOLLOW_SYSTEM
        } else {
            MODE_NIGHT_AUTO_BATTERY
        }
    );

    companion object {
        fun get(@NightMode mode: Int): Theme {
            return values().find { it.mode == mode }!!
        }
    }
}