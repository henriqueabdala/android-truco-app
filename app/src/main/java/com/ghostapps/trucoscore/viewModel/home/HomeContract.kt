package com.ghostapps.trucoscore.viewModel.home

interface HomeContract {
    fun navigateTo(newClass: Class<*>)
    fun closeApp()
}