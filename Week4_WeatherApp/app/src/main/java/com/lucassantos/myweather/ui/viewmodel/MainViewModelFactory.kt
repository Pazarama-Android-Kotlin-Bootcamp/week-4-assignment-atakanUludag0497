package com.lucassantos.myweather.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * MainViewModel Factory.
 */

class MainViewModelFactory constructor(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.application) as T
        } else {
            throw IllegalArgumentException("ViewModel not found!")
        }
    }
}