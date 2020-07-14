package com.william.template.ui.movie.popular

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.BlurTransformation
import coil.transform.RoundedCornersTransformation
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.william.template.R
import com.william.template.model.domain.Movie
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
            transformations(RoundedCornersTransformation(32f))
        }
    }
}

@BindingAdapter("backdropUrl")
fun ImageView.setBackdropUrl(url: String?) {
    url?.let {
        load(TmdbUrl.getBackdropPath(url)) {
            crossfade(true)
            transformations(BlurTransformation(context))
        }
    }
}

@BindingAdapter("chipItems")
fun ChipGroup.setChipItems(movie: Movie) {
    removeAllViews()
    movie.genres.forEach {
        val chip = LayoutInflater.from(context)
            .inflate(R.layout.view_genre_chip, this, false) as Chip
        chip.text = it
        addView(chip)
    }
}