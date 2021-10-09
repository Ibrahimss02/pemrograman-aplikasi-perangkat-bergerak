package com.ibrahim.papb.roomdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.papb.roomdb.database.DAO
import com.ibrahim.papb.roomdb.database.ItemDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(private val databaseDAO: DAO) : ViewModel() {
    private val _items = databaseDAO.getAllItem()
    val items: LiveData<List<ItemDTO>>
        get() = _items

    val judulTv = MutableLiveData<String>()


    fun insertDataToDB() {
        judulTv.value?.let {
            val item = ItemDTO(judul = it)
            viewModelScope.launch(Dispatchers.IO) {
                databaseDAO.insertItem(item)
            }
            judulTv.value = ""
        }
    }

    fun clearDBData() {
        viewModelScope.launch(Dispatchers.IO) {
            databaseDAO.deleteAll()
        }
    }
}