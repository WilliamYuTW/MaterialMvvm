package com.william.template.utils

import androidx.appcompat.app.AppCompatDelegate
import com.tencent.mmkv.MMKV
import com.william.template.domain.Theme
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

@Singleton
class ThemeHelper @Inject constructor(private val mmkv: MMKV) {

    fun getCurrentTheme(): Theme {
        val mode = mmkv.getInt(KEY_THEME, Theme.SYSTEM_DEFAULT.mode)
        return Theme.get(mode)
    }

    fun applyTheme(theme: Theme) {
        AppCompatDelegate.setDefaultNightMode(theme.mode)
        mmkv.putInt(KEY_THEME, theme.mode)
    }

    companion object {
        private const val KEY_THEME = "theme"
    }
}