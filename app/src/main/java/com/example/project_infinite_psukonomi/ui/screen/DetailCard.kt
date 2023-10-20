package com.example.project_infinite_psukonomi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project_infinite_psukonomi.R

@Composable
fun DetailCard() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), modifier = Modifier
            .padding(8.dp)
            .requiredSizeIn(maxHeight = 200.dp, maxWidth = 200.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.imgp),
                contentScale = ContentScale.Inside,
                contentDescription = "Imgae",
                modifier = Modifier.weight(0.8F)
            )
            IconButton(onClick = { /*TODO : Implement favourite feature*/ }) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Icon",
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(0.2F)
                )
            }
        }
        Text(
            text = "Carrot",
            Modifier
                .fillMaxWidth()
                .padding(8.dp, 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Price")
            Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add")
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(start = 16.dp)
    )
}

@Composable
fun DetailList(title: String) {
    Title(title = title)
    LazyRow {
        items(10) {
            DetailCard()
        }
    }
}

@Preview
@Composable
fun Details() {
//    CategoryListPopup(category = listOf("324","sdfsd","sdfsd","sdfd","dfsd"), setShowDialog ={} )
    DetailCard()
}