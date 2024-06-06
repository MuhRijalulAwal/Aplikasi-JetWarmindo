package com.example.jetwarmindo.di

import com.example.jetwarmindo.data.FoodRepository


object Injection {
    fun provideRepository(): FoodRepository {
        return FoodRepository.getInstance()
    }
}