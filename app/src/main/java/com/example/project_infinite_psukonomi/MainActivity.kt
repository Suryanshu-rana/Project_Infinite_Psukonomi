package com.example.project_infinite_psukonomi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.project_infinite_psukonomi.ui.screen.MainScreen
import com.example.project_infinite_psukonomi.ui.theme.Project_Infinite_PsukonomiTheme
import com.example.project_infinite_psukonomi.viewModel.CategoryViewModel
import com.example.project_infinite_psukonomi.viewModel.CategoryViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CategoryViewModel by viewModels { CategoryViewModelFactory(this) }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categorieState.collect { categories ->
                    setContent {
                        Project_Infinite_PsukonomiTheme {
                            // A surface container using the 'background' color from the theme
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                            ) {
                                if (categories != null) {
                                    MainScreen(categories = categories)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
