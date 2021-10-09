package com.ibrahim.papb.roomdb.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [ItemDTO::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract val ItemDatabaseDAO: DAO

    companion object {
        @Volatile
        private var INSTANCE: Database? = null

        fun getInstance(context: Context): Database {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        Database::class.java,
                        "item_database"
                    )
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}