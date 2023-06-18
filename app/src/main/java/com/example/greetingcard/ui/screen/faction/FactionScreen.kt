package com.example.greetingcard.ui.screen.faction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.greetingcard.ui.component.BackHomeButton
import com.example.greetingcard.ui.theme.GreetingCardTheme
import com.example.greetingcard.viewmodel.FactionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactionScreen(onNavigateToHome: () -> Unit) {

    val viewModel: FactionViewModel = hiltViewModel()

    var factionName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Create Faction")
        TextField(
            value = factionName,
            onValueChange = { newValue -> factionName = newValue },
            label = { Text("Faction Name") }
        )
        Button(onClick = { viewModel.createFaction(factionName) }) {
            Text("Submit")
        }
        BackHomeButton(onNavigateToHome)
    }
}

//@Preview annotation allows you to build a preview of the app without building it.
@Preview(showBackground = true)
@Composable
fun FactionScreenPreview() {
    GreetingCardTheme {
        //HomeOptions(onNavigateToComposeArticle = {}, onNavigateToBirthday = {})
        FactionScreen(onNavigateToHome = {})
    }
}