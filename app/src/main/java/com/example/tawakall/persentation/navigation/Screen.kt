package com.example.tawakall.persentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Light : Screen("light")
    object Reading : Screen("reading")
    object Doa : Screen("doa")
    object Bookmark : Screen("bookmark")

    object Detail:Screen("detail/{number}/{arab}/{id}/{riwayah}")
}
