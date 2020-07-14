package com.william.template.ui.movie.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.william.template.databinding.ListItemPopularMovieBinding
import com.william.template.model.domain.Movie
import com.william.template.ui.base.DataBindingAdapter
import com.william.template.ui.base.DataBindingViewHolder

/**
 * @author WeiYi Yu
 * @date 2020-07-09
 */

class PopularMovieAdapter :
    DataBindingAdapter<Movie>(MovieDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingViewHolder<Movie> = ViewHolder.from(parent)

    private class ViewHolder private constructor(val binding: ListItemPopularMovieBinding) :
        DataBindingViewHolder<Movie>(binding) {

        override fun bind(item: Movie) {
            binding.movie = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemPopularMovieBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    private class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}

