package org.d3if0115.asessment1.navigation

import org.d3if0115.asessment1.ui.screen.KEY_ID_ARENA

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_ARENA}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}