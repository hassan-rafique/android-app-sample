package com.devcrew.baseproject.presentation.utils.extension

import android.app.Activity
import android.widget.Toast

fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}