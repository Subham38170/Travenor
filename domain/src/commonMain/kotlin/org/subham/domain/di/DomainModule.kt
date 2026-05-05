package org.subham.domain.di

import org.koin.dsl.module
import org.subham.domain.usecase.GetAllListingUseCase

val domainModule = module{

    factory {
        GetAllListingUseCase(get())

    }

}