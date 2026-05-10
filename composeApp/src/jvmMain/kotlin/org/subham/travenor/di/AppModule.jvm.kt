package org.subham.travenor.di

import org.koin.dsl.module

actual fun platformModule() = module {
    single<String> { "http://localhost:8080" }
}