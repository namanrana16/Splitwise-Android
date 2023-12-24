package com.example.splitwise.domain.use_case.search_transaction

import androidx.paging.PagingData
import com.example.splitwise.data.repository.Repository
import com.example.splitwise.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

class SearchTransactionUseCase( private val repository: Repository) {

operator fun invoke(query:String): Flow<PagingData<Transaction>>
{
    return repository.searchTransactions(query)
}
}