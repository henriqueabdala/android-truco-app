package com.ghostapps.trucoscore.viewModel.home

import androidx.lifecycle.ViewModel
import com.ghostapps.trucoscore.ui.gameRecords.GameRecordsActivity
import com.ghostapps.trucoscore.ui.preGame.PreGameActivity

class HomeViewModel(
    val contract: HomeContract
) : ViewModel() {

    fun onNewGamePressed() {
        contract.navigateTo(PreGameActivity::class.java)
    }

    fun onRecordsPressed() {
        contract.navigateTo(GameRecordsActivity::class.java)
    }

    fun onExitPressed() {
        contract.closeApp()
    }
}