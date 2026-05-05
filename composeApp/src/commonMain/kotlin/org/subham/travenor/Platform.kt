package org.subham.travenor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform