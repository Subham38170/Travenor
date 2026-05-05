package org.subham.presentation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform