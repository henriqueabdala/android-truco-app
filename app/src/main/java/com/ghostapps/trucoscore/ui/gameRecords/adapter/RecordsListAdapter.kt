package com.ghostapps.trucoscore.ui.gameRecords.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghostapps.trucoscore.R
import com.ghostapps.trucoscore.domain.models.RecordModel
import com.ghostapps.trucoscore.viewModel.gameRecords.RecordsItem

class RecordsListAdapter(
    private val list: List<RecordsItem>,
    private val onDeletePressed: (recordModel: RecordModel) -> Unit
): RecyclerView.Adapter<RecordsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_record, parent, false)
        return RecordsListViewHolder(view, onDeletePressed)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecordsListViewHolder, position: Int) {
        holder.bind(list[position])
    }
}