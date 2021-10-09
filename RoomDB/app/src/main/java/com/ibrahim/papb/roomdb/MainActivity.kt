package com.ibrahim.papb.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahim.papb.roomdb.database.DAO
import com.ibrahim.papb.roomdb.database.Database
import com.ibrahim.papb.roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        val dataSource = Database.getInstance(this).ItemDatabaseDAO
        val viewModelFactory = MainActivityViewModelFactory(dataSource)
        val viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]

        binding.mainRv.adapter = ItemRvAdapter()

        binding.viewModel = viewModel
    }
}

class MainActivityViewModelFactory(private val databaseDAO: DAO) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(databaseDAO) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }

}