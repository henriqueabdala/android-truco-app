package com.ghostapps.trucoscore.data.records.remote.useCases

import com.ghostapps.trucoscore.domain.models.RecordModel
import com.ghostapps.trucoscore.domain.useCases.DeleteRegister
import com.google.firebase.firestore.FirebaseFirestore

class DeleteFirebase: DeleteRegister {
    override fun execute(recordModel: RecordModel) {
        FirebaseFirestore
            .getInstance()
            .collection("scores")
            .document(recordModel.date.toString())
            .delete()
            .addOnFailureListener {
                it.localizedMessage ?:  "Ops, houve um problema com o firestone!"
            }
    }
}