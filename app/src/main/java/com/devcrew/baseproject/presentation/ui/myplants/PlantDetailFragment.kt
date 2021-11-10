package com.devcrew.baseproject.presentation.ui.myplants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devcrew.baseproject.databinding.FragmentPlantDetailBinding
import com.devcrew.baseproject.domain.entity.Plant

class PlantDetailFragment : Fragment() {

    private lateinit var binding: FragmentPlantDetailBinding
    private lateinit var plant: Plant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val args = PlantDetailFragmentArgs.fromBundle(it)
            plant = args.plant
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlantDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            obj = plant
        }
    }
}