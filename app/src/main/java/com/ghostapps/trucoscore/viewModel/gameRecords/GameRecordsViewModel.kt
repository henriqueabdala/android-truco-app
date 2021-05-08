package com.ghostapps.trucoscore.viewModel.gameRecords

import androidx.lifecycle.MutableLiveData
import com.ghostapps.trucoscore.domain.models.RecordModel
import com.ghostapps.trucoscore.domain.useCases.DeleteRegister
import com.ghostapps.trucoscore.domain.useCases.GetAllRegister
import com.ghostapps.trucoscore.viewModel.BaseViewModel

class GameRecordsViewModel(
    private val getAllRegister: GetAllRegister,
    private val deleteRegister: DeleteRegister
): BaseViewModel() {

    val recordsList = MutableLiveData<List<RecordsItem>>()

    fun loadRecords() {
        Thread {
            getAllRegister.execute (
                successCallback = {
                    val recordsModel = it.flatMap { recordModel ->
                        val recordList = arrayListOf<RecordsItem>()

                        recordList.add(
                            RecordsItem(
                                homeTeamName = recordModel.homeTeamName,
                                homeTeamScore = recordModel.homeTeamScore,
                                homeTeamScoreFinished = recordModel.homeTeamScoreFinished,
                                awayTeamName = recordModel.awayTeamName,
                                awayTeamScore = recordModel.awayTeamScore,
                                awayTeamScoreFinished = recordModel.awayTeamScoreFinished,
                                date = recordModel.date
                            )
                        )
                        recordList
                    }
                    recordsList.postValue(recordsModel)
                })
        }.start()
    }

    fun deleteRegister(recordModel: RecordModel) {
        Thread {
            deleteRegister.execute(recordModel)
            loadRecords()
        }.start()
    }

}