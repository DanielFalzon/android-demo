package com.example.greetingcard.ui.screen.composearticle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.greetingcard.ui.component.BackHomeButton

@Composable
fun ComposeArticleScreen (onNavigateToHome: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Work in Progress", Modifier.fillMaxSize())
        BackHomeButton(onNavigateToHome)
    }
}