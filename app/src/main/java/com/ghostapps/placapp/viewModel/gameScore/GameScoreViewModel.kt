package com.ghostapps.placapp.viewModel.gameScore

import android.app.AlertDialog
import com.ghostapps.placapp.viewModel.BaseViewModel

class GameScoreViewModel(
    private val contract: GameScoreContract
): BaseViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""

    private var homeTeamScore = 0
    private var awayTeamScore = 0

    var formattedHomeTeamScore = "00"
    var formattedAwayTeamScore = "00"

    var homeTeamScoreFinished = 0
    var awayTeamScoreFinished = 0

    var formattedHomeTeamScoreFinished = "00"
    var formattedAwayTeamScoreFinished = "00"


    fun onCreate(homeTeamName: String, awayTeamName: String) {
        this.homeTeamName = homeTeamName
        this.awayTeamName = awayTeamName
    }

    fun onHomeTeamIncrease() {
        homeTeamScore++
        updateScore()
    }

    fun onHomeTeamDecrease() {
        if (homeTeamScore > 0) homeTeamScore--
        updateScore()
    }

    fun onAwayTeamIncrease() {
        awayTeamScore++
        updateScore()
    }

    fun onAwayTeamDecrease() {
        if (awayTeamScore > 0) awayTeamScore--
        updateScore()
    }

    fun onExitPressed() {
        contract.onExitPressed()
    }

    private fun updateScore() {
        if(homeTeamScore >= 12) homeTeamScoreFinished++
        if(awayTeamScore >= 12) awayTeamScoreFinished++
        if (homeTeamScore == 12 || awayTeamScore == 12) {
            homeTeamScore = 0
            awayTeamScore = 0
        }
        formattedHomeTeamScore = String.format("%02d", homeTeamScore)
        formattedAwayTeamScore = String.format("%02d", awayTeamScore)
        formattedHomeTeamScoreFinished = String.format("%02d", homeTeamScoreFinished)
        formattedAwayTeamScoreFinished = String.format("%02d", awayTeamScoreFinished)
        notifyChange()
    }
}