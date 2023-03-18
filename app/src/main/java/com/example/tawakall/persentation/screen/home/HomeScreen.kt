package com.example.tawakall.persentation.screen.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tawakall.R
import com.example.tawakall.persentation.screen.home.component.CardRecentRead
import com.example.tawakall.persentation.screen.home.component.ViewTabPager

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    var searchQuery by remember { mutableStateOf("") }
    var isSearchExpanded by remember { mutableStateOf(false) }
    val state = viewModel.state.value
    Scaffold(
        modifier = modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp),
        topBar = {
            if (isSearchExpanded) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search") },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = MaterialTheme.colors.onSurface
                    ),
                    leadingIcon = {
                        IconButton(onClick = { isSearchExpanded = false }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        }
                    }
                )
            } else {
                TopAppBar(
                    elevation = 0.dp,
                    backgroundColor = Color.White,
                    title = {
                        Text(
                            text = "Hadist App",
                            style = MaterialTheme.typography.h1,
                            color = MaterialTheme.colors.primary,
                            fontSize = 20.sp
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_menu_top),
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { isSearchExpanded = true }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        }
                    }
                )

            }
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Column(Modifier.padding(start = 17.dp)) {
                Text(
                    text = "Assalamualaikum",
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Text(
                    text = "Welcome my Brother",
                    style = MaterialTheme.typography.h2,
                    fontSize = 24.sp
                )
            }
            CardRecentRead()
            Spacer(modifier = modifier.height(24.dp))
            ViewTabPager(state, state)
        }
    }
}
