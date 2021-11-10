package com.devcrew.baseproject.presentation.ui.myplants

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.devcrew.baseproject.R
import com.devcrew.baseproject.databinding.FragmentAddPlantDialogBinding
import com.devcrew.baseproject.presentation.base.BaseDialogFragment
import com.devcrew.baseproject.presentation.eventbus.EventClickOnAddPlant
import org.greenrobot.eventbus.EventBus


class AddPlantDialogFragment : BaseDialogFragment() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentAddPlantDialogBinding.inflate(inflater, container, false)

    override fun onCreateViewActions() {
        (binding as FragmentAddPlantDialogBinding).apply {
            edtName.requestFocus()
            btnAdd.setOnClickListener {

                if (edtName.text.toString().trim().isBlank()) {
                    setError(edtName)
                    return@setOnClickListener
                }

                if (edtDesc.text.toString().trim().isBlank()) {
                    setError(edtDesc)
                    return@setOnClickListener
                }

                EventBus.getDefault().post(
                    EventClickOnAddPlant(
                        edtName.text.toString().trim(),
                        edtDesc.text.toString().trim()
                    )
                )

                dismiss()

            }
        }
    }

    private fun setError(view: EditText) {
        view.error = resources.getString(R.string.str_empty_error)
        view.requestFocus()
    }

    companion object {
        fun show(context: AppCompatActivity): AddPlantDialogFragment {
            val fragment = AddPlantDialogFragment()
            fragment.create(context, true)
            return fragment
        }
    }
}