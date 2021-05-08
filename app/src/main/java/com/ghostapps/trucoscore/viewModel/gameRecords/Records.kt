package com.ghostapps.trucoscore.viewModel.gameRecords

data class RecordsItem (val homeTeamName: String,
                        val homeTeamScore: Int,
                        val homeTeamScoreFinished: Int,
                        val awayTeamName: String,
                        val awayTeamScore: Int,
                        val awayTeamScoreFinished: Int,
                        val date: Long) {
}