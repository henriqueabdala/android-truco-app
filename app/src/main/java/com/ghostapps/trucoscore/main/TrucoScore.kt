package com.ghostapps.trucoscore.main

import android.app.Application
import com.ghostapps.trucoscore.main.di.DataModules
import com.ghostapps.trucoscore.main.di.InfraModules
import com.ghostapps.trucoscore.main.di.ViewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TrucoScore: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TrucoScore)
            modules(
                ViewModelModules.modules + DataModules.modules + InfraModules.modules
            )
        }

    }

}