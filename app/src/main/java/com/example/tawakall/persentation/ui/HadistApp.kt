package com.example.tawakall.persentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tawakall.R
import com.example.tawakall.domain.model.ReadHadith
import com.example.tawakall.persentation.navigation.NavigationItem
import com.example.tawakall.persentation.navigation.Screen
import com.example.tawakall.persentation.screen.bookmark.BookmarkScreen
import com.example.tawakall.persentation.screen.detail.DetailScreen
import com.example.tawakall.persentation.screen.detail.DetailVIewModel
import com.example.tawakall.persentation.screen.doa.DoaScreen
import com.example.tawakall.persentation.screen.favorite.FavoriteScreen
import com.example.tawakall.persentation.screen.home.HomeScreen
import com.example.tawakall.persentation.screen.remember.RememberScreen
import com.example.tawakall.persentation.ui.theme.Shapes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun HadistApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    vIewModel: DetailVIewModel = hiltViewModel()
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val current = LocalContext.current

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Detail.route) {
                BottomBar(
                    navController = navHostController
                )
            }
        }

    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = navHostController)
            }

            composable(Screen.Light.route) {
                FavoriteScreen()
            }

            composable(Screen.Reading.route) {
                RememberScreen()
            }

            composable(Screen.Doa.route) {
                DoaScreen()
            }

            composable(Screen.Bookmark.route) {
                BookmarkScreen()
            }
            composable(Screen.Detail.route) { backStackEntry ->
                val arguments = requireNotNull(backStackEntry.arguments)
                val number = requireNotNull(arguments.getString("number"))
                val arab = requireNotNull(arguments.getString("arab"))
                val id = requireNotNull(arguments.getString("id"))
                val riwayah = requireNotNull(arguments.getString("riwayah"))

                val scope = rememberCoroutineScope()

                DetailScreen(nomor = number, arab = arab, terjemahan = id, onClickedFavorite = {
                    val read = ReadHadith(riwayah, number)
                    scope.launch(Dispatchers.IO) {
                        vIewModel.insertRead(read)
                    }
                })
            }
        }
    }
}


@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
//    buttom navigation untuk list itemnya
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 15.dp,
    ) {

//        simpan state terbaru
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.home),
                icon = ImageVector.vectorResource(id = R.drawable.icon_home),
                screen = Screen.Home
            ),


            NavigationItem(
                title = "Light",
                icon = ImageVector.vectorResource(id = R.drawable.icon_light),
                screen = Screen.Light
            ),

            NavigationItem(
                title = "Reading",
                icon = ImageVector.vectorResource(id = R.drawable.icon_syahwi),
                screen = Screen.Reading
            ),

            NavigationItem(
                title = "Doa",
                icon = ImageVector.vectorResource(id = R.drawable.icon_doa),
                screen = Screen.Doa
            ),


            NavigationItem(
                title = "Bookmark",
                icon = ImageVector.vectorResource(id = R.drawable.icon_bookmark),
                screen = Screen.Bookmark
            ),
        )

//        buttom navigation untuk konfiurasi itemnya
        BottomNavigation(
            modifier = modifier.shadow(
                elevation = 2.dp,
                shape = Shapes.medium,
            ),
            backgroundColor = Color.White,
            elevation = 15.dp,
        ) {
            navigationItems.map { item ->
                BottomNavigationItem(
                    selectedContentColor = MaterialTheme.colors.primary,
                    unselectedContentColor = MaterialTheme.colors.primaryVariant,

//                    ini harus sesuai dengan yang di click berdasarkan screen route
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
//                        imageVector = ImageVector.vectorResource(id = item.icon),
                            imageVector = item.icon,
                            contentDescription = null
                        )
                    },
                )
            }
        }
    }
}