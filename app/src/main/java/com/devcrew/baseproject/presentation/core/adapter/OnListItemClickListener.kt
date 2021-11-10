package com.devcrew.baseproject.presentation.core.adapter

import android.view.View

interface OnListItemClickListener <T> {
    fun onItemClick(obj: T, position: Int, view: View)
}