package com.ghostapps.trucoscore.data.records

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghostapps.trucoscore.domain.models.RecordModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = RecordEntity.TABLE_NAME)
class RecordEntity(

    @SerializedName("team_a_name")
    val homeTeamName: String,
    @SerializedName("team_a_score")
    val homeTeamScore: Int,
    @SerializedName("team_a_score_finished")
    val homeTeamScoreFinished: Int,

    @SerializedName("team_b_name")
    val awayTeamName: String,
    @SerializedName("team_b_score")
    val awayTeamScore: Int,
    @SerializedName("team_b_score_finished")
    val awayTeamScoreFinished: Int,

    @PrimaryKey
    @SerializedName("timestamp")
    val date: Long
) {
    companion object {
        const val TABLE_NAME = "records_database"

        fun fromModel(recordModel: RecordModel): RecordEntity {
            return RecordEntity(
                homeTeamName = recordModel.homeTeamName,
                homeTeamScore = recordModel.homeTeamScore,
                homeTeamScoreFinished = recordModel.homeTeamScoreFinished,

                awayTeamName = recordModel.awayTeamName,
                awayTeamScore = recordModel.awayTeamScore,
                awayTeamScoreFinished = recordModel.awayTeamScoreFinished,

                date = recordModel.date
            )
        }
    }

    fun toModel(): RecordModel {
        return RecordModel(
            homeTeamName = homeTeamName,
            homeTeamScore = homeTeamScore,
            homeTeamScoreFinished = homeTeamScoreFinished,

            awayTeamName = awayTeamName,
            awayTeamScore = awayTeamScore,
            awayTeamScoreFinished = awayTeamScoreFinished,

            date = date
        )
    }
}