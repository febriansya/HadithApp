package com.example.tawakall.persentation.screen.home.component

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tawakall.R
import com.example.tawakall.persentation.screen.home.ReadLastViewModel
import com.example.tawakall.persentation.ui.theme.Shapes

@Composable
fun CardRecentRead(
    viewModel: ReadLastViewModel,
    modifier: Modifier = Modifier,
) {


    val lastReade = viewModel.stateRead
    Log.d("3", "$lastReade")


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val boxSize = with(LocalDensity.current) { 325.dp.toPx() }
        Box(
            modifier = modifier
                .width(325.dp)
                .height(131.dp)
                .clip(Shapes.medium)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colors.secondaryVariant,
                            MaterialTheme.colors.onPrimary
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(boxSize, boxSize)
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.quran),
                contentDescription = null,
                modifier = modifier
                    .align(Alignment.BottomEnd)
                    .width(206.dp)
                    .height(126.dp)
            )
            Column(modifier = modifier.padding(start = 20.dp, top = 19.dp)) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_read),
                        contentDescription = null,
                        modifier = modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Last Read",
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.White
                    )
                }

                if (lastReade.isNullOrEmpty()) {
                    Toast.makeText(
                        LocalContext.current,
                        "Perlu dipanggil di background",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val terakhir = lastReade.last()

                    if (terakhir.isNullOrEmpty()) {
                        Toast.makeText(LocalContext.current, "Tunggu dulu", Toast.LENGTH_SHORT)
                            .show()
                    } else {

                        Spacer(modifier = Modifier.height(20.dp))
                        val getasik = getLast(terakhir)
                        Text(
                            text = "${getasik?.riwayah}",
                            style = MaterialTheme.typography.h2,
                            color = Color.White
                        )
                        Text(
                            text = "No. ${getasik?.number}",
                            style = MaterialTheme.typography.body1,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}


fun <T> getLast(list: List<T>): T? {
    var lastItem: T? = null
    for (e in list) {
        lastItem = e
    }
    return lastItem
}
