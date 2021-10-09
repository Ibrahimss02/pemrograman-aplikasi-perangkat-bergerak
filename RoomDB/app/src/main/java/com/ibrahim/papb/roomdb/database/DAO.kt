package com.ibrahim.papb.roomdb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAO {
    @Insert
    suspend fun insertItem(items : ItemDTO)

    @Query("SELECT * from item_table ORDER BY id")
    fun getAllItem() : LiveData<List<ItemDTO>>

    @Query("DELETE from item_table")
    suspend fun deleteAll()

    @Update
    suspend fun update(item : ItemDTO)
}