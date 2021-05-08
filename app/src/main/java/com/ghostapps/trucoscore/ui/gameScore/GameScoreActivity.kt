package com.ghostapps.trucoscore.ui.gameScore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ghostapps.trucoscore.R
import com.ghostapps.trucoscore.databinding.ActivityScoreGameBinding
import com.ghostapps.trucoscore.viewModel.gameScore.GameScoreContract
import com.ghostapps.trucoscore.viewModel.gameScore.GameScoreViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GameScoreActivity: AppCompatActivity(), GameScoreContract {

    companion object {
        const val TEAM_HOME_NAME = "home_team_name"
        const val TEAM_AWAY_NAME = "away_team_name"
    }

    private lateinit var binding: ActivityScoreGameBinding
    private val viewModel: GameScoreViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score_game)
        binding.viewModel = viewModel

        viewModel.onCreate(intent.getStringExtra(TEAM_HOME_NAME) ?: "", intent.getStringExtra(TEAM_AWAY_NAME) ?: "")
    }

    override fun onExitPressed() {
        finish()
    }

}