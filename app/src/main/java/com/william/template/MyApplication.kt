package com.william.template

import android.app.Application
import com.tencent.mmkv.MMKV
import com.william.template.tools.ThemeHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */
class MyApplication : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        delayInit()
    }

    private fun delayInit() {
        applicationScope.launch {
            MMKV.initialize(applicationContext)
            val defaultMMKV = MMKV.defaultMMKV()
            val currentTheme = ThemeHelper.getCurrentTheme(defaultMMKV)
            ThemeHelper.applyTheme(defaultMMKV, currentTheme)
        }
    }
}