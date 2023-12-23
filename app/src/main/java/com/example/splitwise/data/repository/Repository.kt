package com.example.splitwise.data.repository

import com.example.splitwise.domain.model.HomeDetails
import com.example.splitwise.domain.repository.DataStoreOperations
import com.example.splitwise.domain.repository.LocalDataSource
import com.example.splitwise.domain.repository.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val local :LocalDataSource,
    private val remote : RemoteDataSource,
    private val dataStore : DataStoreOperations
)
{
suspend fun getHomeDetails(): HomeDetails
{

return local.getHomeDetails()
}
}
