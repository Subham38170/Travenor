package org.subham.domain.di

import org.koin.dsl.module
import org.subham.domain.usecase.GetAllListingUseCase
import org.subham.domain.usecase.GetListingByIdUseCase
import org.subham.domain.usecase.GetTokenUseCase
import org.subham.domain.usecase.RegisterUseCase
import org.subham.domain.usecase.SignInUseCase

val domainModule = module {

    factory {
        GetAllListingUseCase(get())

    }

    factory {
        SignInUseCase(get())
    }

    factory {
        RegisterUseCase(get())
    }

    factory {
        GetTokenUseCase(get())
    }

    factory {
        GetListingByIdUseCase(get())
    }
}