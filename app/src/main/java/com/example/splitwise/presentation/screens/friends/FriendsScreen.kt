package com.example.splitwise.presentation.screens.friends

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FriendsListScreen(friends: List<Friend>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(friends) { friend ->
            FriendListItem(friend)
        }
    }
}

@Composable
fun FriendListItem(friend: Friend) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = friend.name,
                style = MaterialTheme.typography.labelSmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            BalanceRow(
                balance = friend.balance,
                onSettleClick = { /* Handle settling individual debt */ },
            )
            Spacer(modifier = Modifier.height(8.dp))
            GroupDebtBreakdown(friend.groupDebts)
        }
    }
}

@Composable
fun BalanceRow(balance: Double, onSettleClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Balance: ₹${balance.format(2)}",
            style = MaterialTheme.typography.bodyMedium,
        )
        Button(
            onClick = onSettleClick,
            modifier = Modifier.padding(vertical = 8.dp),
        ) {
            Text(text = "Settle Now")
        }
    }
}

@Composable
fun GroupDebtBreakdown(groupDebts: List<GroupDebt>) {
    Text(
        text = "Group Debts:",
        style = MaterialTheme.typography.bodySmall,
    )
    Spacer(modifier = Modifier.height(4.dp))
    groupDebts.forEach { debt ->
        Text(
            text = "- ${debt.group}: ₹${debt.amount}",
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

data class Friend(
    val name: String,
    val balance: Double,
    val groupDebts: List<GroupDebt>,
)

data class GroupDebt(
    val group: String,
    val amount: Double,
)

fun Double.format(decimals: Int): String = String.format("%.${decimals}f", this)


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FriendsListPreview() {
    FriendsListScreen(friends = listOf(
        Friend(
            name = "Sarah Jones",
            balance = 50.25,
            groupDebts = listOf(
                GroupDebt(group = "Dinner Club", amount = 25.00),
                GroupDebt(group = "Movie Night", amount = 10.75),
            )
        ),
        Friend(
            name = "Michael Brown",
            balance = -12.30,
            groupDebts = listOf(
                GroupDebt(group = "Travel Fund", amount = 45.00),
            )
        ),
    ))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GroupDebtBreakdownPreview() {
    GroupDebtBreakdown(groupDebts = listOf(
        GroupDebt(group = "Coffee Club", amount = 8.50),
        GroupDebt(group = "Weekend Trip", amount = 32.00),
    ))
}