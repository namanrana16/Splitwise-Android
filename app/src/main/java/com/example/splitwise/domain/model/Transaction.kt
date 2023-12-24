package com.example.splitwise.domain.model

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "Transaction")
data class Transaction(

    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val amount: Double,
)
