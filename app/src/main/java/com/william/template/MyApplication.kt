package com.william.template

import android.app.Application
import com.william.template.utils.ThemeHelper
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

@HiltAndroidApp
class MyApplication : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    @Inject
    lateinit var themeHelper: ThemeHelper

    override fun onCreate() {
        super.onCreate()
        delayInit()
    }

    private fun delayInit() {
        applicationScope.launch {
            val currentTheme = themeHelper.getCurrentTheme()
            themeHelper.applyTheme(currentTheme)
        }
    }
}