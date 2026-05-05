package org.subham.travenor

import androidx.compose.ui.window.ComposeUIViewController
import org.subham.travenor.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin {  }
    }
){ App() }