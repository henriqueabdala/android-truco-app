package com.ghostapps.trucoscore.domain.useCases

import com.ghostapps.trucoscore.domain.models.RecordModel

interface InsertRegister {
    fun execute(recordModel: RecordModel)
}