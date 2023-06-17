
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.R
import com.example.greetingcard.ui.theme.GreetingCardTheme

@Composable
fun BirthdayScreen(
    message: String,
    from: String,
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit
) {
    val image = painterResource(R.drawable.androidparty)
    //Box layout composable is used to place elements on top of eachother
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.size(16.dp))
            BirthdayText(
                message = message,
                from = from,
                modifier = modifier
                    .padding(8.dp)
            )
            Button(
                onClick = onNavigateToHome,
                modifier = Modifier.fillMaxWidth().height(64.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(0)
            ) {
                Text(
                    text = "< Back to Home",
                    fontSize = 16.sp,
                    modifier = Modifier,
                    color = Color.Black
                )
            }
        }
    }
}

//@Preview annotation allows you to build a preview of the app without building it.
@Preview(showBackground = true)
@Composable
fun BirthdayScreenPreview() {
    GreetingCardTheme {
        //HomeOptions(onNavigateToComposeArticle = {}, onNavigateToBirthday = {})
        BirthdayScreen(message = "Happy Birthday", from = "Daniele", onNavigateToHome =  { })
    }
}