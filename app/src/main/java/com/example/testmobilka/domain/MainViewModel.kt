package com.example.testmobilka.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel()
{
    private val _products = MutableStateFlow<Products?>(null)
    val products: StateFlow<Products?> = _products
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage
    init {
        fetchProducts()
    }
    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val fetchedProducts = RetrofitInstance.apiService.getProducts()
                _products.value = fetchedProducts
                _errorMessage.value = null
            } catch (e: Exception) {
                _products.value = null!!
                _errorMessage.value = "Error fetching products: ${e.message}"
            }
        }
    }
}