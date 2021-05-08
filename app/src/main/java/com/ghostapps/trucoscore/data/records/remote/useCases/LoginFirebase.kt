package com.ghostapps.trucoscore.data.records.remote.useCases

import com.ghostapps.trucoscore.domain.useCases.Login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException


class LoginFirebase(
    private val firebaseAuth: FirebaseAuth
): Login {
    override fun execute(
        email: String,
        password: String,
        sucessCallback: () -> Unit,
        failureCallBack: (errorMessage: String) -> Unit
    ) {
       firebaseAuth.signInWithEmailAndPassword(email, password)
           .addOnSuccessListener {
               sucessCallback()
           }
           .addOnFailureListener {
               if((it as? FirebaseAuthInvalidUserException)?.errorCode == "ERROR_USER_NOT_FOUND"){
                    firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnSuccessListener {
                            sucessCallback()
                        }
                        .addOnFailureListener {
                            failureCallBack(
                                it.localizedMessage ?: "Erro ao realizar login, tente novamente mais tarde"
                            )
                        }
               } else {
                   failureCallBack(
                       it.localizedMessage ?: "Erro ao realizar login, tente novamente mais tarde"
                   )
               }
           }

    }
}