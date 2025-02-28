package com.example.testmobilka.data

import com.example.testmobilka.domain.Product
import com.example.testmobilka.domain.Products
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
    @GET("products")
    suspend fun getProducts():Products
}