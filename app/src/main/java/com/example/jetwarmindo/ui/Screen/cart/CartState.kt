package com.example.jetwarmindo.ui.Screen.cart

import com.example.jetwarmindo.model.OrderFood

data class CartState(
    val orderReward: List<OrderFood>,
    val totalRequiredPoint: Int
)