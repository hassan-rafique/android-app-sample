package com.devcrew.baseproject.presentation.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devcrew.baseproject.presentation.core.adapter.GenericRecyclerViewAdapter
import com.devcrew.baseproject.presentation.core.adapter.OnItemViewClickListener
import com.devcrew.baseproject.presentation.core.adapter.OnListItemClickListener

@BindingAdapter(value = ["imageUrl", "default"], requireAll = false)
fun loadImage(view: ImageView, imageUrl: String?, default: Drawable?) {
    if (default == null) {
        Glide.with(view.context).load(imageUrl).into(view)
    } else {
        Glide.with(view.context).load(imageUrl).placeholder(default).into(view)
    }
}

@BindingAdapter("imgResource")
fun setImage(view: ImageView, imgResource: Int) {
    view.setImageResource(imgResource)
}

@BindingAdapter(
    value = ["itemsList", "itemLayout", "itemClickListener", "hasFixSize", "onItemViewClick"],
    requireAll = false
)
fun <T> setItems(
    view: RecyclerView, itemsList: List<T>, layout: Int,
    itemClickListener: OnListItemClickListener<T>?, hasFixSize: Boolean = false,
    onItemViewClick: OnItemViewClickListener<T>?
) {
    val mAdapter = GenericRecyclerViewAdapter(layout, itemsList)
    view.adapter = mAdapter
    mAdapter.setItemClickListener(itemClickListener)
    mAdapter.itemViewClickListener = onItemViewClick
    view.setHasFixedSize(hasFixSize)
}