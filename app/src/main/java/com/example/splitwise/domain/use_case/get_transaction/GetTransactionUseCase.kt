package com.example.splitwise.domain.use_case.get_transaction

import com.example.splitwise.data.repository.Repository
import com.example.splitwise.domain.model.Transaction

class GetTransactionUseCase( private val repository: Repository) {

    suspend operator fun invoke(transactionId: Int):Transaction {
        return repository.getTransaction(transactionId)
    }
}