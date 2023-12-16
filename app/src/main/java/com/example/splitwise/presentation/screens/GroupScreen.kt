package com.example.splitwise.presentation.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GroupListScreen(groups: List<Group>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(groups) { group ->
            GroupListItem(group)
        }
    }
}

@Composable
fun GroupListItem(group: Group) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            // Group image
            androidx.compose.foundation.Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(id =  com.example.splitwise.R.drawable.ic_launcher_foreground),
                contentDescription = group.name,
            )
            Spacer(modifier = Modifier.width(8.dp))
            // Group name and list of members
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = group.name,
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.height(4.dp))
                MemberList(group.members)
            }
            // Total amount (owed/owed to you)
            Text(
                text = formatAmount(group.totalAmount),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Right,
            )
        }
    }
}

@Composable
fun MemberList(members: List<Member>) {
    members.forEachIndexed { index, member ->
        Text(
            text = "${member.name}: ₹${member.amount}",
            style = MaterialTheme.typography.bodyMedium,
            color = if (member.amount >= 0) Color.Red else Color.Green,
        )
        if (index < members.lastIndex) {
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

fun formatAmount(amount: Double): String = String.format("%.2f", amount)

data class Group(
    val name: String,
    val image: Image, // Replace with your image source
    val members: List<Member>,
    val totalAmount: Double,
)

data class Member(
    val name: String,
    val amount: Double, // Positive for owed by you, negative for owed to you
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GroupListPreview() {
    GroupListScreen(groups = listOf(
        Group(
            name = "Weekend Trip",
            //image = Image,

            members = listOf(Member(name = "John", amount = 20.00), Member(name = "Jane", amount = -30.00)),
            totalAmount = -10.00,
        ),
        Group(
            name = "Coffee Club",
            //image = ImageAsset("coffee_image.png"),
            members = listOf(Member(name = "Emma", amount = 5.00), Member(name = "David", amount = 2.50)),
            totalAmount = 7.50,
        ),
    ))
}