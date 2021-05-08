package com.ghostapps.trucoscore.main.di

import com.ghostapps.trucoscore.data.records.local.useCases.DeleteLocalRegister
import com.ghostapps.trucoscore.data.records.local.useCases.GetAllLocalRegister
import com.ghostapps.trucoscore.data.records.local.useCases.InsertLocalRegister
import com.ghostapps.trucoscore.data.records.remote.useCases.DeleteFirebase
import com.ghostapps.trucoscore.data.records.remote.useCases.GetAllFirebase
import com.ghostapps.trucoscore.data.records.remote.useCases.InsertFirebase
import com.ghostapps.trucoscore.data.records.remote.useCases.LoginFirebase
import com.ghostapps.trucoscore.viewModel.gameRecords.GameRecordsViewModel
import com.ghostapps.trucoscore.viewModel.gameScore.GameScoreContract
import com.ghostapps.trucoscore.viewModel.gameScore.GameScoreViewModel
import com.ghostapps.trucoscore.viewModel.home.HomeContract
import com.ghostapps.trucoscore.viewModel.home.HomeViewModel
import com.ghostapps.trucoscore.viewModel.login.LoginContract
import com.ghostapps.trucoscore.viewModel.login.LoginViewModel
import com.ghostapps.trucoscore.viewModel.preGame.PreGameContract
import com.ghostapps.trucoscore.viewModel.preGame.PreGameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.contracts.contract

object ViewModelModules {
    val modules = module {
        viewModel { (contract: LoginContract) ->
            LoginViewModel(contract, get<LoginFirebase>())
        }
        viewModel { (contract: HomeContract) ->
            HomeViewModel(contract)
        }
        viewModel {(contract: PreGameContract) ->
            PreGameViewModel(contract)
        }
        viewModel {(contract: GameScoreContract) ->
            GameScoreViewModel(contract, get<InsertFirebase>())
        }
        viewModel {
            GameRecordsViewModel(get<GetAllFirebase>(), get<DeleteFirebase>())
        }
    }
}