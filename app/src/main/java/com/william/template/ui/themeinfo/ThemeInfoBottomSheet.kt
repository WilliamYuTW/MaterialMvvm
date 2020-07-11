package com.william.template.ui.themeinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
import com.william.template.R
import com.william.template.databinding.BottomSheetThemeInfoBinding
import com.william.template.model.domain.Theme
import com.william.template.utils.ThemeHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.view_theme_toggle_group.view.*
import javax.inject.Inject

@AndroidEntryPoint
class ThemeInfoBottomSheet : BottomSheetDialogFragment() {

    @Inject
    lateinit var themeHelper: ThemeHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = BottomSheetThemeInfoBinding.inflate(inflater)

        binding.root.themeToggleGroup.check(getToggleButtonId(themeHelper.getCurrentTheme()))

        binding.checkedListener = OnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked.not()) {
                return@OnButtonCheckedListener
            }

            themeHelper.applyTheme(
                when (checkedId) {
                    R.id.btnLightTheme -> {
                        Theme.LIGHT
                    }
                    R.id.btnNightTheme -> {
                        Theme.NIGHT
                    }
                    else -> Theme.SYSTEM_DEFAULT
                }
            )
        }
        return binding.root
    }

    override fun show(manager: FragmentManager, tag: String?) {
        // Prevent dialog shows twice
        manager.findFragmentByTag(tag) ?: run {
            super.show(manager, tag)
        }
    }

    private fun getToggleButtonId(theme: Theme) = when (theme) {
        Theme.NIGHT -> R.id.btnNightTheme
        Theme.LIGHT -> R.id.btnLightTheme
        Theme.SYSTEM_DEFAULT -> R.id.btnSystemTheme
    }
}