package com.liming.playandroid.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author pangliming
 *
 */
abstract class BaseRecyclerAdapter<V : ViewBinding> :
    RecyclerView.Adapter<BaseRecyclerAdapter.BaseRecyclerViewHolder<V>>() {
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<V>

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<V>, position: Int) {
            onBaseBindViewHolder(position, holder.binding)
    }

    abstract fun onBaseBindViewHolder(position: Int, binding: V)
    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    open class BaseRecyclerViewHolder<V : ViewBinding>(val binding: V) :
        RecyclerView.ViewHolder(binding.root) {

    }
}