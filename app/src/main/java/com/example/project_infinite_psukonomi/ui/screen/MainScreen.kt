package com.example.project_infinite_psukonomi.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project_infinite_psukonomi.model.Categories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(categories: Categories) {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        CategoryListPopup(listOf("Food", "Gifts", "Drinks", "Stationary"), setShowDialog = {
            showDialog.value = it
        })
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row {
                    Column(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .weight(0.8F)
                    ) {
                        Text(text = "My Store")
                    }
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.1F)) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "notification"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.1F)) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "notification"
                        )
                    }
                }
            }, navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Nav Icon",
                    modifier = Modifier.size(30.dp)
                )
            }, colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color(0xFFFFC55C),
                scrolledContainerColor = Color(0xFF002c3d),
                navigationIconContentColor = Color.Black,
                titleContentColor = Color.Black,
                actionIconContentColor = Color.Black
            )
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog.value = true },
                containerColor = Color.Black,
                contentColor = Color.White,
                modifier = Modifier.padding(bottom = 32.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(imageVector = Icons.Default.List, contentDescription = "Categories")
                    Text(text = "Categories", style = MaterialTheme.typography.titleSmall)
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            LazyColumn {
                items(categories.categories) { product ->
                    DetailList(title = product.name, product)
                }
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun Prevfun() {
//    MainScreen()
}