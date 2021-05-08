package com.ghostapps.trucoscore.domain.useCases

import com.ghostapps.trucoscore.domain.models.RecordModel

interface GetAllRegister {
    fun execute(successCallback: (recordList: Array<RecordModel>) -> Unit)
}