package com.devcrew.baseproject.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devcrew.baseproject.R
import com.devcrew.baseproject.databinding.ActivityMainBinding
import com.devcrew.baseproject.domain.entity.NavDrawerItem
import com.devcrew.baseproject.presentation.base.BaseActivity
import com.devcrew.baseproject.presentation.core.adapter.OnListItemClickListener
import com.devcrew.baseproject.presentation.utils.*
import com.devcrew.baseproject.presentation.utils.extension.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    private val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavigation()

        binding.viewModel = mViewModel
        binding.itemClickListener = OnDrawerItemClickListener()
        setSupportActionBar(binding.toolbar)
        showToggle()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.plantDetailFragment -> {
                    changeToolbarText(resources.getString(R.string.str_plant_detail))
                    setUpMainUiForCommon()
                }
                else -> {
                    changeToolbarText(resources.getString(R.string.app_name))
                    setUpMainUiForHome()
                }
            }
        }
    }

    inner class OnDrawerItemClickListener : OnListItemClickListener<NavDrawerItem> {
        override fun onItemClick(obj: NavDrawerItem, position: Int, view: View) {
            when (obj.id) {
                ABOUT_US -> {
                    toast(obj.title)
                }
                PRIVACY_POLICY -> {
                    toast(obj.title)
                }
                SHARE -> {
                    toast(obj.title)
                }
                RATE_US -> {
                    toast(obj.title)
                }
                HOW_TO_USE -> {
                    toast(obj.title)
                }
                FEEDBACK -> {
                    toast(obj.title)
                }
            }
        }
    }

    private fun setUpBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
    }

    private fun showToggle() {
        val toggle = ActionBarDrawerToggle(
            this, binding.drawer, binding.toolbar,
            R.string.str_navigation_drawer_open, R.string.str_navigation_drawer_close
        )
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun changeToolbarText(text: String) {
        supportActionBar!!.title = text
    }

    private fun lockedDrawer() {
        binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        binding.bottomNav.isVisible = false
    }

    private fun unlockedDrawer() {
        binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        binding.bottomNav.isVisible = true
    }

    private fun visibleBackArrow() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun invisibleBackArrow() {
        supportActionBar!!.setHomeButtonEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayShowHomeEnabled(false)
    }

    private fun setUpMainUiForCommon() {
        visibleBackArrow()
        lockedDrawer()
    }

    private fun setUpMainUiForHome() {
        unlockedDrawer()
        invisibleBackArrow()
        showToggle()
    }
}