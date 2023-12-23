package com.example.splitwise.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.text.DateFormat
import java.util.Date


@Composable
fun HomeScreen(navController: NavHostController){


}


@Composable
fun PaymentList(payments: List<Payment>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(payments) { payment ->
            PaymentItem(payment)
        }
    }
}

@Composable
fun PaymentItem(payment: Payment) {
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
                text = "From: ${payment.sender}",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = "To: ${payment.receiver}",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = "Amount: ₹${payment.amount}",
                style = MaterialTheme.typography.labelMedium,
            )
            Text(
                text = DateFormat.getDateInstance().format(payment.date),
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = payment.description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

data class Payment(
    val sender: String,
    val receiver: String,
    val amount: Double,
    val date: Date,
    val description: String,
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PaymentListPreview() {
    PaymentList(payments = listOf(
        Payment(
            sender = "John Doe",
            receiver = "Jane Smith",
            amount = 100.00,
            date = Date(2023, 12, 16),
            description = "Payment for groceries",
        ),
        Payment(
            sender = "Jane Smith",
            receiver = "John Doe",
            amount = 50.00,
            date = Date(2023, 12, 15),
            description = "Movie ticket reimbursement",
        ),
    ))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PaymentItemPreview() {
    PaymentItem(payment = Payment(
        sender = "John Doe",
        receiver = "Jane Smith",
        amount = 100.00,
        date = Date(2023, 12, 16),
        description = "Payment for groceries",
    )
    )
}