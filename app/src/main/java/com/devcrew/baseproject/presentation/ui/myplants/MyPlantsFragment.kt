package com.devcrew.baseproject.presentation.ui.myplants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.devcrew.baseproject.databinding.FragmentMyplantsBinding
import com.devcrew.baseproject.domain.entity.Plant
import com.devcrew.baseproject.presentation.core.adapter.OnItemViewClickListener
import com.devcrew.baseproject.presentation.core.adapter.OnListItemClickListener
import com.devcrew.baseproject.presentation.core.navigation.navigate
import com.devcrew.baseproject.presentation.eventbus.EventClickOnAddPlant
import com.devcrew.baseproject.presentation.utils.extension.toast
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

@AndroidEntryPoint
class MyPlantsFragment : Fragment() {

    private lateinit var binding: FragmentMyplantsBinding

    private val mViewModel: MyPlantsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyplantsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = mViewModel
            itemCLickListener = OnPlantItemClickListener()
            onItemViewClick = OnPlantItemViewClickListener()
            fab.setOnClickListener {
                AddPlantDialogFragment.show(activity as AppCompatActivity)
            }
        }

        mViewModel.responseMessage.observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty())
                toast(it)
        })

        mViewModel.getPlantsList().observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                mViewModel.myPlants.value = it
                binding.txtErr.visibility = View.GONE
            } else {
                mViewModel.myPlants.value = it
                binding.txtErr.visibility = View.VISIBLE
            }
        })
    }

    inner class OnPlantItemViewClickListener : OnItemViewClickListener<Plant> {
        override fun onItemViewClick(item: Plant, rootView: View, view: View) {
            mViewModel.deletePlant(item)
        }
    }

    inner class OnPlantItemClickListener : OnListItemClickListener<Plant> {
        override fun onItemClick(obj: Plant, position: Int, view: View) {
            binding.navigate {
                MyPlantsFragmentDirections.actionMyPlantsFragmentToPlantDetailFragment(
                    obj
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onEvent(event: EventClickOnAddPlant) {
        mViewModel.addPlant(Plant(name = event.name, description = event.desc))
    }
}