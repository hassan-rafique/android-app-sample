package com.devcrew.baseproject.presentation.core.navigation

import androidx.databinding.ViewDataBinding
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.devcrew.baseproject.R


inline fun ViewDataBinding.navigate(action: () -> NavDirections) {
    root.findNavController().navigate(action.invoke())
}

// Add your global navigation functions here

fun ViewDataBinding.gotoPlantDetail() {
    //navigation code goes here
    root.findNavController().navigate(R.id.action_myPlantsFragment_to_plantDetailFragment)
}



