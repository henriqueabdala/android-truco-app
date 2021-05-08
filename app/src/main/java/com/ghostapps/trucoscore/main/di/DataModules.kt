package com.ghostapps.trucoscore.main.di

import org.koin.dsl.module
import androidx.room.Room
import com.ghostapps.trucoscore.data.records.local.RecordDatabase
import com.ghostapps.trucoscore.data.records.RecordEntity
import com.ghostapps.trucoscore.data.records.local.useCases.DeleteLocalRegister
import com.ghostapps.trucoscore.data.records.local.useCases.GetAllLocalRegister
import com.ghostapps.trucoscore.data.records.local.useCases.InsertLocalRegister
import com.ghostapps.trucoscore.data.records.remote.useCases.*


import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.koin.androidApplication

object DataModules {
    val modules = module {
        single {
            Room.databaseBuilder(
                androidApplication(),
                RecordDatabase::class.java,
                RecordEntity.TABLE_NAME
            ).fallbackToDestructiveMigration().build()
        }

        factory {
            InsertFirebase()
        }

        factory {
            DeleteFirebase()
        }

        factory {
            GetAllLocalRegister(get())
        }

        factory {
            GetAllFirebase()
        }



        factory {
            LoginFirebase(FirebaseAuth.getInstance())
        }

    }
}