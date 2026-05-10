package org.subham.travenor

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.subham.travenor.di.initKoin
import java.awt.Dimension

fun main() = application {
    initKoin { }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Travenor",
        state = rememberWindowState(width = 800.dp, height = 600.dp)

    ) {
        window.minimumSize = Dimension(500, 700)
        App()
    }
}