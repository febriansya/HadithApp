package com.example.tawakall.persentation.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tawakall.persentation.screen.detail.component.ItemDetailScreen


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    nomor: String,
    arab: String,
    terjemahan: String,
    onClickedFavorite: () -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        ItemDetailScreen(
            nomor = nomor,
            arab = arab,
            terjemahan = terjemahan,
            click = onClickedFavorite
        )
    }
}

