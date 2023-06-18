package com.example.greetingcard.ui.screen.faction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.greetingcard.data.model.Faction
import com.example.greetingcard.ui.component.BackHomeButton
import com.example.greetingcard.ui.theme.GreetingCardTheme
import com.example.greetingcard.viewmodel.FactionViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactionScreen(onNavigateToHome: () -> Unit) {

    val viewModel: FactionViewModel = hiltViewModel()
    val factions: List<Faction> by viewModel.factions.collectAsState()

    var factionName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Factions", fontSize = 32.sp)
        LazyColumn(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(480.dp)
        ){
            items(factions.size) { index ->
                val faction = factions[index]
                Row(
                    modifier = Modifier
                        .height(40.dp),
                    horizontalArrangement = Arrangement.Start
                ){
                    Column(
                        modifier = Modifier
                            .size(40.dp)
                            .background(color = Color.DarkGray)
                    ){
                        Button(
                            onClick = { /* Call your delete method here */ },
                            Modifier
                                .size(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "X",
                                color = Color.Black,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .background(color = Color.DarkGray)
                    ) {
                        // Faction name
                        Text(
                            text = faction.name,
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Gray)
                                .padding(start = 10.dp)
                        )
                    }
                }
                Spacer(Modifier.height(4.dp))
            }
        }
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