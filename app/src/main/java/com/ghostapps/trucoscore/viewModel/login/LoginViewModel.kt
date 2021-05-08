package com.ghostapps.trucoscore.viewModel.login

import androidx.lifecycle.MutableLiveData
import com.ghostapps.trucoscore.domain.useCases.Login
import com.ghostapps.trucoscore.ui.home.HomeActivity
import com.ghostapps.trucoscore.viewModel.BaseViewModel

class LoginViewModel(
    private val contract: LoginContract,
    private val login: Login
): BaseViewModel() {
    var email: String = ""
    var password: String = ""

    var errorMessage = MutableLiveData<String>()

    fun onLoginPressed(){
        login.execute(
            email = email,
            password =  password,
            sucessCallback = {
                contract.navigateTo(HomeActivity::class.java)
            },
            failureCallBack = { errorMessage ->
                this.errorMessage.postValue(errorMessage)
            }

        )
    }

}