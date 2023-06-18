package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.greetingcard.ui.navigation.NavigationView
import com.example.greetingcard.ui.theme.GreetingCardTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * @AndroidEntryPoint is a Hilt annotation that generates an individual Hilt component for each Android class in your project.
 * These components can receive dependencies from their respective parent classes and also from the singleton component.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // onCreate function == main()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent invokes @Composable functions. Used by Jetpack Compose to generate UI
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationView(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}






