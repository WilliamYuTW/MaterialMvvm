package com.william.template.ui.movie.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.william.template.databinding.ListItemPopularMovieBinding
import com.william.template.network.dto.TmdbMovie

/**
 * @author WeiYi Yu
 * @date 2020-07-09
 */

class PopularMovieAdapter :
    ListAdapter<TmdbMovie, PopularMovieAdapter.ViewHolder>(TmdbMovieDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder private constructor(val binding: ListItemPopularMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: TmdbMovie) {
            binding.tmdbMovie = movie
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
}

class TmdbMovieDiffCallback : DiffUtil.ItemCallback<TmdbMovie>() {
    override fun areItemsTheSame(oldItem: TmdbMovie, newItem: TmdbMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TmdbMovie, newItem: TmdbMovie): Boolean {
        return oldItem == newItem
    }
}
