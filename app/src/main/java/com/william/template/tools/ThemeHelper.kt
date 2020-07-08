package com.william.template.tools

import androidx.appcompat.app.AppCompatDelegate
import com.tencent.mmkv.MMKV

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */
object ThemeHelper {

    private const val KEY_THEME = "theme"

    fun getCurrentTheme(mmkv: MMKV): Theme {
        val mode = mmkv.getInt(KEY_THEME, Theme.SYSTEM_DEFAULT.mode)
        return Theme.get(mode)
    }

    fun applyTheme(mmkv: MMKV, theme: Theme) {
        AppCompatDelegate.setDefaultNightMode(theme.mode)
        mmkv.putInt(KEY_THEME, theme.mode)
    }
}