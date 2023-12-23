package com.example.splitwise.domain.model

import androidx.paging.PagingData
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "HomeDetails")
data class HomeDetails (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
) : Flow<PagingData<HomeDetails>> {
    override suspend fun collect(collector: FlowCollector<PagingData<HomeDetails>>) {
        TODO("Not yet implemented")
    }
}
