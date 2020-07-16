package com.william.template.ui.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * @author WeiYi Yu
 * @date 2020-07-15
 */
abstract class DataBindingAdapter<T>(
    itemDiffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBindingViewHolder<T>>(itemDiffCallback) {

    private var onItemClickListener: ((item: T, position: Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (item: T, position: Int) -> Unit) {
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<T>, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(item, position)
        }
    }
}