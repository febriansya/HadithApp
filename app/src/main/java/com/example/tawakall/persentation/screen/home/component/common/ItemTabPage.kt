package com.example.tawakall.persentation.screen.home.component.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tawakall.R

@Composable
fun ItemTabPage(
    modifier: Modifier = Modifier,
    nomor: Int,
    title: String,
    arab: String,
    author:String,
    navController: NavController,
    onClick: () -> Unit,

) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.halman_surah),
                contentDescription = null
            )
            Text(
                text = nomor.toString(),
                style = MaterialTheme.typography.subtitle2,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Text(
                    text = author,
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = 12.sp,
                    color = Color.LightGray
                )
//                Text(
//                    text = "7 VERSES",
//                    style = MaterialTheme.typography.subtitle2,
//                    fontSize = 12.sp,
//                    color = Color.LightGray
//                )
            }
            Text(
                text = arab,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = MaterialTheme.colors.primary,
                modifier = modifier
            )
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle2,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        }
    }
}

