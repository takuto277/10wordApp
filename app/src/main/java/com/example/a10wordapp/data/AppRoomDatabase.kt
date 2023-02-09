package com.example.a10wordapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a10wordapp.data.db.dao.InitialQuizDao
import com.example.a10wordapp.data.db.dao.UserEditQuizDao
import com.example.a10wordapp.data.db.entity.InitialQuizEntity
import com.example.a10wordapp.data.db.entity.UserEditQuizEntity

/**
 * Database class with a singleton INSTANCE object.
 */
@Database(
    entities = [UserEditQuizEntity::class, InitialQuizEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun userEditQuizDataDao(): UserEditQuizDao
    abstract fun initialQuizDataDao(): InitialQuizDao

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