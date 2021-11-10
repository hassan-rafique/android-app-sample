package com.devcrew.baseproject.presentation.core.adapter

import androidx.annotation.LayoutRes
import com.devcrew.baseproject.presentation.base.BaseRecyclerViewAdapter

class GenericRecyclerViewAdapter<T>(
    @LayoutRes private val layoutId: Int,
    items: List<T> = emptyList()
) : BaseRecyclerViewAdapter<T>(items) {

    override fun getItemViewType(position: Int): Int = layoutId

}