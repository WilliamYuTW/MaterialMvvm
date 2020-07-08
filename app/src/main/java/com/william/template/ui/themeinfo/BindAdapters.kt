package com.william.template.ui.themeinfo

import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

@BindingAdapter("checkedListener")
fun MaterialButtonToggleGroup.checkedListener(listener: OnButtonCheckedListener) {
    addOnButtonCheckedListener(listener)
}