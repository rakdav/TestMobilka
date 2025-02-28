package com.example.testmobilka.presenter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testmobilka.domain.MainViewModel
import com.example.testmobilka.domain.Product
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun  ProductListScreen(viewModel: MainViewModel = viewModel()) {
    val posts by viewModel.products.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    MaterialTheme {
        Column {
            if (errorMessage != null) {
                Text(
                    text = "Error: ${errorMessage!!}",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(posts!!.products) { post ->
                        PostItem(post = post)
                    }
                }
            }
        }
    }
}
@Composable
fun PostItem(post: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Title: ${post.title}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Body: ${post.sku}", style = MaterialTheme.typography.bodySmall)
        }
    }
}