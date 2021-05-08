package com.ghostapps.trucoscore.data.records.local.useCases

import com.ghostapps.trucoscore.data.records.local.RecordDatabase
import com.ghostapps.trucoscore.data.records.RecordEntity
import com.ghostapps.trucoscore.domain.models.RecordModel
import com.ghostapps.trucoscore.domain.useCases.DeleteRegister

class DeleteLocalRegister(
    private val database: RecordDatabase
) : DeleteRegister {
    override fun execute(recordModel: RecordModel) {
        database.recordDao().delete(RecordEntity.fromModel(recordModel))
    }
}