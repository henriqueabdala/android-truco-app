package com.ghostapps.trucoscore.data.records.local.useCases

import com.ghostapps.trucoscore.data.records.local.RecordDatabase
import com.ghostapps.trucoscore.domain.models.RecordModel
import com.ghostapps.trucoscore.domain.useCases.GetAllRegister

class GetAllLocalRegister(
    private val database: RecordDatabase
) : GetAllRegister {

    fun execute(): Array<RecordModel> {
        return database.recordDao().getRecords().map { recordEntity -> recordEntity.toModel() }.toTypedArray()
    }

    override fun execute(successCallback: (recordList: Array<RecordModel>) -> Unit) {
        TODO("Not yet implemented")
    }
}