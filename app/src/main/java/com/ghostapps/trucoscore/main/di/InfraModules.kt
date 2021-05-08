package com.ghostapps.trucoscore.main.di

import com.ghostapps.trucoscore.infra.http.HttpAdapter
import org.koin.dsl.module

object InfraModules {
    val modules = module {
        factory {
            HttpAdapter()
        }
    }
}