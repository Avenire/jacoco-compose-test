package com.kamil.coverage

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun InstrumentationComposable(enabled: Boolean = true, callback: () -> Unit = {}) {
    if(enabled) {
        Button(onClick = callback) {
            Text(text = "Click me")
        }
    } else {
        Text(text = "No clicking")
    }
}