package com.example.splitwise.domain.repository

import androidx.paging.PagingData
import com.example.splitwise.domain.model.HomeDetails
import java.util.concurrent.Flow

interface RemoteDataSource {

fun getHomeDetails():kotlinx.coroutines.flow.Flow<PagingData<HomeDetails>>

fun setHomeDetails(query:String):kotlinx.coroutines.flow.Flow<PagingData<HomeDetails>>
}