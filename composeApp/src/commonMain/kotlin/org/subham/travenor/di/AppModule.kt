package org.subham.travenor.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.subham.data.di.dataModule
import org.subham.domain.di.domainModule
import org.subham.presentation.di.presentationModule

val appModule = module {
    includes(presentationModule, dataModule, domainModule,platformModule())

}


expect fun platformModule(): Module