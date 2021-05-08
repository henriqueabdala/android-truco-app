package com.ghostapps.trucoscore.ui.gameRecords.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ghostapps.trucoscore.viewModel.gameRecords.RecordsItem
import kotlinx.android.synthetic.main.item_game_record.view.*
import com.ghostapps.trucoscore.domain.models.RecordModel as RecordModel1

class RecordsListViewHolder(itemView: View, private val onDeletePressed: (recordModel: RecordModel1) -> Unit): RecyclerView.ViewHolder(itemView) {

    fun bind(record: RecordsItem) {
        itemView.itemGameRecordHomeTeamName.text = record.homeTeamName
        itemView.itemGameRecordHomeTeamScoreFinished.text = record.homeTeamScoreFinished.toString()

        itemView.itemGameRecordAwayTeamName.text = record.awayTeamName
        itemView.itemGameRecordAwayTeamScoreFinished.text = record.awayTeamScoreFinished.toString()

        itemView.itemGameRecordDelete.setOnClickListener {
            onDeletePressed(
                RecordModel1(
                    homeTeamName = record.homeTeamName,
                    homeTeamScore = record.homeTeamScore,
                    homeTeamScoreFinished =  record.homeTeamScoreFinished,
                    awayTeamName = record.awayTeamName,
                    awayTeamScore = record.awayTeamScoreFinished,
                    awayTeamScoreFinished = record.awayTeamScoreFinished,
                    date = record.date
                )
            )
        }
    }

}