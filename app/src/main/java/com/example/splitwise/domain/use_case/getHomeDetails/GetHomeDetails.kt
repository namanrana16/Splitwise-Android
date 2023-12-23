package com.example.splitwise.domain.use_case.getHomeDetails

import androidx.paging.PagingData
import com.example.splitwise.data.repository.Repository
import com.example.splitwise.domain.model.HomeDetails
import kotlinx.coroutines.flow.Flow

class GetHomeDetails(private val repository: Repository) {

suspend operator fun invoke(): Flow<PagingData<HomeDetails>> {
return repository.getHomeDetails()
}
}