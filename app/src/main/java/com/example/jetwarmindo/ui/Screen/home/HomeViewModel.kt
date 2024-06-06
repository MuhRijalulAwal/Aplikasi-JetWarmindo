package com.example.jetwarmindo.ui.Screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetwarmindo.data.FoodRepository
import com.example.jetwarmindo.model.OrderFood
import com.example.jetwarmindo.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: FoodRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderFood>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderFood>>>
        get() = _uiState

    fun getAllFoods() {
        viewModelScope.launch {
            repository.getAllFoods()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }
}