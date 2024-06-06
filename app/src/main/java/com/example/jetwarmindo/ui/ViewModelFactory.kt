package com.example.jetwarmindo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetwarmindo.data.FoodRepository
import com.example.jetwarmindo.ui.Screen.cart.CartViewModel
import com.example.jetwarmindo.ui.Screen.detail.DetailViewModel
import com.example.jetwarmindo.ui.Screen.home.HomeViewModel

class ViewModelFactory(private val repository: FoodRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}