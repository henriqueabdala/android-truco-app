package com.ghostapps.trucoscore.domain.useCases

interface Login {
    fun execute(
        email: String,
        password: String,
        sucessCallback: () -> Unit,
        failureCallBack: (errorMessage: String) -> Unit
    )
}