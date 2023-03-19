package com.example.tawakall.persentation.screen.home.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tawakall.persentation.screen.detail.DetailScreen
import com.example.tawakall.persentation.screen.home.HadithListState
import com.example.tawakall.persentation.screen.home.component.common.ItemTabPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewTabPager(
    state1: HadithListState,
    state2: HadithListState,
    context: Context,
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val pages = listOf<String>(
        "Abu Daud",
        "Bukhari",
        "Tirmidzi",
        "Nasai",
        "Ibnu Majah",
        "Ahmad",
        "Darimi",
        "Malik"
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ScrollableTabRow(
            backgroundColor = Color.White,
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }) {
            pages.forEachIndexed { index, title ->
                Tab(
                    selectedContentColor = MaterialTheme.colors.primary,
                    text = {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.h2,
                            fontSize = 16.sp
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    })
            }
        }
        HorizontalPager(
            count = pages.size,
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { page ->
            when (page) {
                0 -> {
                    LazyColumn {
                        items(state1.hadith) { hadith ->
                            ItemTabPage(
                                nomor = hadith.number,
                                title = hadith.id,
                                arab = hadith.arab,
                                navController = navController
                            ){
                                navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}")
                            }
                        }
                    }
                }
            }
        }
    }
}
