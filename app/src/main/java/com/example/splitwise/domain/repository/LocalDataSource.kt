package com.example.splitwise.domain.repository

import com.example.splitwise.domain.model.HomeDetails

interface LocalDataSource {

    suspend fun getHomeDetails(): HomeDetails
}