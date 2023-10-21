package com.example.project_infinite_psukonomi.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.project_infinite_psukonomi.model.Categories
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoryViewModel(context: Context) : ViewModel() {

    private val _categorieState = MutableStateFlow(getQuotesFromJson(context))
    val categorieState: StateFlow<Categories?> = _categorieState.asStateFlow()

    /**
     * @author Suryanshu
     * This is a method to Open the json file and extract all the data from it.
     * @param context Context to create input stream to open json file.
     * @return response that contains json data.
     * */
    private fun getQuotesFromJson(context: Context): Categories? {
        // Your Json file should be contain as an array that it will parse otherwise it will give error
        val inputStream = context.assets.open("categories.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val response = gson.fromJson(json, Categories::class.java)
        Log.v("List of categories", response.toString())
        return response
    }
}