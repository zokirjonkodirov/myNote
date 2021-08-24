package com.example.memory.mynote.ui

import android.content.Context
import android.widget.Toast

/**
 * @author user
 * @date 23.08.2021
 */
fun Context.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()