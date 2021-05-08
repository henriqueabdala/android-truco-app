package com.ghostapps.trucoscore.viewModel.login

import android.content.Intent

interface LoginContract {
    fun navigateTo(newClass: Class<*>)
}