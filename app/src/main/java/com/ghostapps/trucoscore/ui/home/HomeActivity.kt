package com.ghostapps.trucoscore.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import com.ghostapps.trucoscore.R
import com.ghostapps.trucoscore.databinding.ActivityHomeBinding
import com.ghostapps.trucoscore.viewModel.home.HomeContract
import com.ghostapps.trucoscore.viewModel.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeActivity : AppCompatActivity(), HomeContract {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = viewModel
    }

    override fun navigateTo(newClass: Class<*>) {
        val intent = Intent(this, newClass)
        startActivity(intent)
    }

    override fun closeApp() {
        finish()
    }

}