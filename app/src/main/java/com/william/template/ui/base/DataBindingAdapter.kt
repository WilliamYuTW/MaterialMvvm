package com.william.template.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * @author WeiYi Yu
 * @date 2020-07-15
 */
abstract class DataBindingAdapter<T>(
    itemDiffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBindingViewHolder<T>>(itemDiffCallback) {

    var onItemClickListener: DataBindingViewHolder.OnItemClickListener<T>? = null

    override fun onBindViewHolder(holder: DataBindingViewHolder<T>, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClicked(item, position)
        }
    }
}

abstract class DataBindingViewHolder<T>(binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)

    interface OnItemClickListener<T> {
        fun onItemClicked(item: T, position: Int)
    }
}
