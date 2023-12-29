package com.example.splitwise.data.remote

import com.example.splitwise.domain.model.ApiResponse
import retrofit2.http.GET

interface SplitwiseApi {

@GET("")
suspend fun getTransactions(): ApiResponse
}