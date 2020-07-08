package com.william.template.di

import android.content.Context
import com.tencent.mmkv.MMKV
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

@Module
@InstallIn(ApplicationComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideMmkv(@ApplicationContext applicationContext: Context): MMKV {
        MMKV.initialize(applicationContext)
        return MMKV.defaultMMKV()
    }
}