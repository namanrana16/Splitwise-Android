package com.example.splitwise.data.repository

import androidx.paging.PagingData
import com.example.splitwise.domain.model.HomeDetails
import com.example.splitwise.domain.model.Transaction
import com.example.splitwise.domain.repository.DataStoreOperations
import com.example.splitwise.domain.repository.LocalDataSource
import com.example.splitwise.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
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

    fun searchTransactions(query:String):Flow<PagingData<Transaction>>
    {

        return remote.searchTransaction(query = query)
    }
    suspend fun savedOnBoardingState(completed:Boolean){
        dataStore.saveOnBoardingState(completed = completed)

    }

    fun readOnBoardingState(): Flow<Boolean>
    {
        return dataStore.readOnBoardingState()
    }


    suspend fun getTransaction(transactionId:Int):Transaction
    {
        return local.getTransaction(transactionId = transactionId)
    }
}
