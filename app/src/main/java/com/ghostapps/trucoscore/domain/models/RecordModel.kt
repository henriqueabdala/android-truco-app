package com.ghostapps.trucoscore.domain.models

class RecordModel(
    val homeTeamName: String,
    val homeTeamScore: Int,
    val homeTeamScoreFinished: Int,


    val awayTeamName: String,
    val awayTeamScore: Int,
    val awayTeamScoreFinished: Int,

    val date: Long
){ constructor() : this("", 0, 0, "", 0, 0, 0) {} }