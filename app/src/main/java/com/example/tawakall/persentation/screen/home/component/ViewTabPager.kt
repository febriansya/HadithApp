package com.example.tawakall.persentation.screen.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tawakall.persentation.screen.home.GetHadistViewModel
import com.example.tawakall.persentation.screen.home.component.common.ItemTabPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewTabPager(
    viewModel: GetHadistViewModel,
    navController: NavController
) {
    val pages = listOf<String>(
        "Abu Daud",
        "Bukhari",
        "Tirmidzi",
        "Nasai",
        "Ibnu Majah",
        "Ahmad",
        "Darimi",
        "Malik",
        "Muslim"
    )
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    LaunchedEffect(pagerState.currentPage) {
        viewModel.getAllNewHadist(pagerState.currentPage)
    }
    val state = viewModel.state.value
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
        if (!state.isLoading) {
            HorizontalPager(
                count = pages.size,
                modifier = Modifier.fillMaxSize(),
                state = pagerState
            ) { page ->
                when (page) {

                    0 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                items(it.hadiths) { hadith ->
                                    val riwayah = state.riwayah?.name.toString()
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }
                    }
                    1 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                val riwayah = state.riwayah?.name.toString()
                                items(it.hadiths) { hadith ->
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }
                    }
                    2 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                val riwayah = state.riwayah?.name.toString()
                                items(it.hadiths) { hadith ->
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }
                    }
                    3 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                val riwayah = state.riwayah?.name.toString()
                                items(it.hadiths) { hadith ->
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }

                    }
                    4 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                val riwayah = state.riwayah?.name.toString()
                                items(it.hadiths) { hadith ->
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }
                    }
                    5 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                val riwayah = state.riwayah?.name.toString()
                                items(it.hadiths) { hadith ->
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }

                    }
                    6 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                items(it.hadiths) { hadith ->
                                    val riwayah = state.riwayah?.name.toString()
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }

                    }
                    7 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                val riwayah = state.riwayah?.name.toString()
                                items(it.hadiths) { hadith ->
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }

                    }
                    8 -> {
                        LazyColumn {
                            state.riwayah?.let {
                                val riwayah = state.riwayah?.name.toString()
                                items(it.hadiths) { hadith ->
                                    ItemTabPage(
                                        nomor = hadith.number,
                                        title = hadith.id,
                                        arab = hadith.arab,
                                        author = state.riwayah?.name.toString(),
                                        navController = navController
                                    ) {
                                        navController.navigate("detail/${hadith.number}/${hadith.arab}/${hadith.id}/${riwayah}")
                                    }
                                }
                            }
                        }

                    }
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}
