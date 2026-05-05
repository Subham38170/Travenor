package org.subham.travenor

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.subham.travenor.di.initKoin

fun main() = application {
    initKoin { }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Travenor",
    ) {
        App()
    }
}