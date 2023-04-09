package com.example.tawakall.persentation.screen.detail.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tawakall.R


@Composable
fun ItemDetailScreen(
    modifier: Modifier = Modifier,
    nomor: String,
    arab: String,
    terjemahan: String,
    click: () -> Unit
) {

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 5.dp)
            .background(Color.Transparent)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            backgroundColor = Color(121931).copy(alpha = 0.094f),
            border = BorderStroke(0.dp, Color.Transparent),
            modifier = modifier.fillMaxWidth(),
            elevation = 0.dp,
            shape = RoundedCornerShape(10),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(9.dp)
                    .background(color = Color.Transparent)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier.background(Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_18),
                        contentDescription = null
                    )
                    Text(
                        text = nomor.toString(),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
                IconButton(onClick = { /*TODO*/ }, modifier = modifier.weight(1f)) {

                }
                IconButton(onClick = click) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_bookmark),
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = arab,
            color = Color(0xff240F4F),
            modifier = modifier.align(Alignment.End),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.caption
        )
        Text(
            text = terjemahan,
            style = MaterialTheme.typography.body1,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        )
    }
}
