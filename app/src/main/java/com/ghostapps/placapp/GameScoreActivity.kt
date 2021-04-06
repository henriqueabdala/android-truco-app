package com.ghostapps.placapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score_game.*

class GameScoreActivity: AppCompatActivity() {

    companion object {
        const val TEAM_HOME_NAME = "home_team_name"
        const val TEAM_AWAY_NAME = "away_team_name"
    }
    
    var homeTeamScore = 0
    var awayTeamScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_game)

        gameScoreHomeTeamName.text = intent.getStringExtra(TEAM_HOME_NAME)
        gameScoreAwayTeamName.text = intent.getStringExtra(TEAM_AWAY_NAME)

        gameScoreHomeIncrease.setOnClickListener { 
            homeTeamScore++
            updateScore()
        }
        
        gameScoreHomeDecrease.setOnClickListener { 
            if (homeTeamScore > 0) homeTeamScore--
            updateScore()
        }
        
        gameScoreAwayIncrease.setOnClickListener {  
            awayTeamScore++
            updateScore()
        }
        
        gameScoreAwayDecrease.setOnClickListener { 
            if (awayTeamScore > 0) awayTeamScore--
            updateScore()
        }

        gameScoreExitButton.setOnClickListener {
            finish()
        }
    }
    
    private fun updateScore() {
        gameScoreHomeTeamScore.text = String.format("%02d", homeTeamScore)
        gameScoreAwayTeamScore.text = String.format("%02d", awayTeamScore)

        if ((homeTeamScore == 11) && (awayTeamScore == 11)) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Mão de Onze!")
            builder.setPositiveButton("OK"){dialog, which ->
                dialog.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        if ((homeTeamScore == 12) || (awayTeamScore == 12)) {
            homeTeamScore = 0
            awayTeamScore = 0
            gameScoreHomeTeamScore.text = String.format("%02d", homeTeamScore)
            gameScoreAwayTeamScore.text = String.format("%02d", awayTeamScore)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("TRUCO!")
            if (homeTeamScore > awayTeamScore) {
                builder.setMessage("O Vencedor foi " + intent.getStringExtra(TEAM_AWAY_NAME))
            }else {
                builder.setMessage("O Vencedor foi " + intent.getStringExtra(TEAM_HOME_NAME))
            }
            builder.setPositiveButton("OK"){dialog, which ->
                dialog.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

    }

}