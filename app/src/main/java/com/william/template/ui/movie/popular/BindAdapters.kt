package com.william.template.ui.movie.popular

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.william.template.R
import com.william.template.network.TmdbUrl

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

@BindingAdapter("posterUrl")
fun ImageView.setPosterUrl(url: String?) {
    url?.let {
        load(TmdbUrl.getPosterPath(url)) {
            placeholder(R.drawable.anim_loading)
            error(R.drawable.ic_broken)
            crossfade(true)
            transformations(RoundedCornersTransformation(8f))
        }
    }
}

@BindingAdapter("backdropUrl")
fun ImageView.setBackdropUrl(url: String?) {
    url?.let {
        load(TmdbUrl.getBackdropPath(url)) {
            crossfade(true)
            transformations(RoundedCornersTransformation(8f))
        }
    }
}