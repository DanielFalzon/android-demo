import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

/**
 * The first screen that is display with all the buttons.
 * Callbacks need to be passed to define navigation per page.
 */

@Composable
fun HomeScreen(
    onNavigateToBirthday: () -> Unit,
    onNavigateToComposeArticle: () -> Unit,
    onNavigateToFactions: () -> Unit
) {
    Column (
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(32.dp)
            .background(Color.White)
            .fillMaxSize()
    ) {
        Text(
            text = "Select an exercise to load:",
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            fontSize = 32.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Left
        )
        Button( onClick = onNavigateToBirthday,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Birthday Greeting Card", color = Color.White)
        }
        Button( onClick = onNavigateToComposeArticle,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Compose Article", color = Color.White)
        }
        Button( onClick = onNavigateToFactions,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Factions", color = Color.White)
        }
    }
}

//@Preview annotation allows you to build a preview of the app without building it.
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    GreetingCardTheme {
        //HomeOptions(onNavigateToComposeArticle = {}, onNavigateToBirthday = {})
        HomeScreen(onNavigateToBirthday = {}, onNavigateToComposeArticle = {}, onNavigateToFactions = {})
    }
}