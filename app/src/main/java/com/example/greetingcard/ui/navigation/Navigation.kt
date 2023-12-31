package com.example.greetingcard.ui.navigation

import BirthdayScreen
import HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greetingcard.R
import com.example.greetingcard.ui.screen.composearticle.ComposeArticleScreen
import com.example.greetingcard.ui.screen.faction.FactionScreen

@Composable
fun NavigationView(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            //Defining the navigation logic for each page with a button on the home page
            HomeScreen(
                onNavigateToBirthday = { navController.navigate("exercise-1-birthday") },
                onNavigateToComposeArticle = { navController.navigate("exercise-2-compose-article")},
                onNavigateToFactions = { navController.navigate("exercise-3-superhero-factions")}
            )
        }
        composable("exercise-1-birthday") {
            BirthdayScreen(
                message = stringResource(R.string.happy_birthday_general),
                from = stringResource(R.string.from_daniel),
                modifier = modifier,
                onNavigateToHome = { navController.navigate("home") }
            )
        }
        composable("exercise-2-compose-article") {
            ComposeArticleScreen {
                navController.navigate("home")
            }
        }
        composable("exercise-3-superhero-factions") {
            FactionScreen{
                navController.navigate("home")
            }
        }
    }
}