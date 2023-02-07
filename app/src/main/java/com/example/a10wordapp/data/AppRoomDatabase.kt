package com.example.a10wordapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a10wordapp.data.db.dao.InitialQuizDataDao
import com.example.a10wordapp.data.db.dao.UserEditQuizDataDao
import com.example.a10wordapp.data.db.entity.InitialQuizDataEntity
import com.example.a10wordapp.data.db.entity.UserEditQuizDataEntity

/**
 * Database class with a singleton INSTANCE object.
 */
@Database(
    entities = [UserEditQuizDataEntity::class, InitialQuizDataEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun userEditQuizDataDao(): UserEditQuizDataDao
    abstract fun initialQuizDataDao(): InitialQuizDataDao

    companion object {
        @Volatile

        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(context: Context): AppRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "item_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}