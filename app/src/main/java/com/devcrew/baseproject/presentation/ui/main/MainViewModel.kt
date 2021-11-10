package com.devcrew.baseproject.presentation.ui.main

import android.content.Context
import com.devcrew.baseproject.R
import com.devcrew.baseproject.domain.entity.NavDrawerItem
import com.devcrew.baseproject.presentation.base.BaseViewModel
import com.devcrew.baseproject.presentation.utils.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext val context: Context,
) : BaseViewModel() {

    val navDrawerItems: List<NavDrawerItem> by lazy {
        listOf(
            NavDrawerItem(
                ABOUT_US,
                context.resources.getString(R.string.str_about_us),
                R.drawable.ic_about
            ),
            NavDrawerItem(
                PRIVACY_POLICY,
                context.resources.getString(R.string.str_policy),
                R.drawable.ic_privacy_policy
            ),
            NavDrawerItem(
                RATE_US,
                context.resources.getString(R.string.str_rate_us),
                R.drawable.ic_rate_us
            ),
            NavDrawerItem(
                SHARE,
                context.resources.getString(R.string.str_share),
                R.drawable.ic_share
            ),
            NavDrawerItem(
                HOW_TO_USE,
                context.resources.getString(R.string.str_how_to_use),
                R.drawable.ic_guide
            ),
            NavDrawerItem(
                FEEDBACK,
                context.resources.getString(R.string.str_feedback),
                R.drawable.ic_feedback
            )
        )
    }

}