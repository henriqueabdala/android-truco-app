package com.ghostapps.trucoscore.domain.useCases

import com.ghostapps.trucoscore.domain.models.RecordModel

interface DeleteRegister {
    fun execute(recordModel: RecordModel)
}