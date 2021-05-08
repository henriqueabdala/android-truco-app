package com.ghostapps.trucoscore.data.records.remote.useCases

import com.ghostapps.trucoscore.domain.models.RecordModel
import com.ghostapps.trucoscore.domain.useCases.GetAllRegister
import com.google.firebase.firestore.FirebaseFirestore

class GetAllFirebase: GetAllRegister {
    override fun execute(successCallback: (recordList: Array<RecordModel>) -> Unit) {
        var scores = arrayListOf<RecordModel>()
        FirebaseFirestore
            .getInstance()
            .collection("scores")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    scores.add(document.toObject(RecordModel::class.java))
                }
                successCallback(scores.toArray(arrayOfNulls<RecordModel>(0)))
            }
            .addOnFailureListener {
                it.localizedMessage ?: "Ops, houve um problema com o firestone!"
            }
    }
}