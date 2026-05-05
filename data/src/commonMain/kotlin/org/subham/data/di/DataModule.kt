package org.subham.data.di

import org.koin.dsl.module
import org.subham.data.datasource.DummyDataSource
import org.subham.data.repository.ListingRepositoryImpl
import org.subham.domain.repository.ListingRepository

val dataModule = module {

    single { DummyDataSource() }

    single<ListingRepository> {
        ListingRepositoryImpl(get())
    }
}