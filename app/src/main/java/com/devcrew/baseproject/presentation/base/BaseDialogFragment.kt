package com.devcrew.baseproject.presentation.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() {

    protected lateinit var binding: ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initBinding(inflater, container)
        binding.lifecycleOwner = this

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        onCreateViewActions()

        return binding.root
    }

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): ViewDataBinding

    abstract fun onCreateViewActions()

    protected fun create(context: AppCompatActivity, cancelable: Boolean) {
        isCancelable = cancelable
        show(context.supportFragmentManager, "")
    }

}