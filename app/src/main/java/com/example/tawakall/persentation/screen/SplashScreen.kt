package com.example.tawakall.persentation.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tawakall.R

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {
    val splashColor = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.name_app),
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h1
//            color = Color(0XFF672CBC)
        )
        Text(
            text = stringResource(id = R.string.splash_description),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primaryVariant
        )
        Box(
            modifier = modifier.padding(bottom = 50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_splash),
                contentDescription = null,
                modifier = modifier
                    .size(450.dp)
                    .padding(bottom = 20.dp)
            )
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                onClick = { /*TODO*/ },
                shape = CircleShape,
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .paddingFromBaseline(top = 40.dp)
                    .height(60.dp)
                    .width(185.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.get_started),
                    color = Color.White,
                    style = MaterialTheme.typography.h2
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true, name = "PIXEL_4")
@Composable
fun SplashPrev() {
    SplashScreen()
}