package com.ghostapps.trucoscore.data.records.local.useCases

import com.ghostapps.trucoscore.data.records.local.RecordDatabase
import com.ghostapps.trucoscore.data.records.RecordEntity
import com.ghostapps.trucoscore.domain.models.RecordModel
import com.ghostapps.trucoscore.domain.useCases.InsertRegister

class InsertLocalRegister(
    private val database: RecordDatabase
): InsertRegister {
    override fun execute(recordModel: RecordModel) {
        database.recordDao().insert(RecordEntity.fromModel(recordModel))
    }
}