package com.example.splitwise.domain.repository

import com.example.splitwise.domain.model.HomeDetails
import com.example.splitwise.domain.model.Transaction

interface LocalDataSource {

    suspend fun getHomeDetails(): HomeDetails

    suspend fun getTransaction(transactionId: Int): Transaction

}