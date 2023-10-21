package com.example.project_infinite_psukonomi.model


data class Categories(
    val status: Boolean,
    var message: String,
    var error: Any,
    var categories: List<Product>
)