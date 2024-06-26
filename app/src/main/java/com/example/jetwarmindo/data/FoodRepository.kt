package com.example.jetwarmindo.data

import com.example.jetwarmindo.model.FakeFoodDataSource
import com.example.jetwarmindo.model.OrderFood
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class FoodRepository {

    private val orderFoods = mutableListOf<OrderFood>()

    init {
        if (orderFoods.isEmpty()) {
            FakeFoodDataSource.dummyFoods.forEach {
                orderFoods.add(OrderFood(it, 0))
            }
        }
    }

    fun getAllFoods(): Flow<List<OrderFood>> {
        return flowOf(orderFoods)
    }

    fun getOrderFoodById(foodId: Long): OrderFood {
        return orderFoods.first {
            it.food.id == foodId
        }
    }

    fun updateOrderFood(foodId: Long, newCountValue: Int): Flow<Boolean> {
        val index = orderFoods.indexOfFirst { it.food.id == foodId }
        val result = if (index >= 0) {
            val orderFood = orderFoods[index]
            orderFoods[index] =
                orderFood.copy(food = orderFood.food, count = newCountValue)
            true
        } else {
            false
        }
        return flowOf(result)
    }

    fun getAddedOrderFoods(): Flow<List<OrderFood>> {
        return getAllFoods()
            .map { orderFoods ->
                orderFoods.filter { orderFood ->
                    orderFood.count != 0
                }
            }
    }

    companion object {
        @Volatile
        private var instance: FoodRepository? = null

        fun getInstance(): FoodRepository =
            instance ?: synchronized(this) {
                FoodRepository().apply {
                    instance = this
                }
            }
    }
}