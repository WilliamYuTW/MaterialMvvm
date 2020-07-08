package com.william.template.customviews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.core.content.withStyledAttributes
import com.william.template.R
import kotlinx.android.synthetic.main.view_color_info.view.*
import java.util.*

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */
class ColorInfo @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_color_info, this)

        context.withStyledAttributes(attrs, R.styleable.ColorInfo) {
            tvTitle.text = getString(R.styleable.ColorInfo_ci_title)
            setColor(getColor(R.styleable.ColorInfo_ci_color, Color.WHITE))
        }
    }

    private fun setColor(@ColorInt color: Int) {
        container.setCardBackgroundColor(color)
        tvColor.apply {
            text = Integer.toHexString(color).toUpperCase(Locale.getDefault())
            setTextColor(getTextColor(color))
        }
    }

    /**
     * Adjust the text color depends on the background color
     * Ref: https://gomakethings.com/dynamically-changing-the-text-color-based-on-background-color-contrast-with-vanilla-js/
     */
    private fun getTextColor(@ColorInt color: Int): Int {
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        val yiq = ((red * 299) + (green * 587) + (blue * 114)) / 1000
        return if (yiq >= 128) Color.BLACK else Color.WHITE
    }
}