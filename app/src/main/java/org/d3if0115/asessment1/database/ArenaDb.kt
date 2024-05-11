package org.d3if0115.asessment1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0115.asessment1.model.Arena

@Database(entities = [Arena::class], version = 1, exportSchema = false)
abstract class ArenaDb: RoomDatabase() {
    abstract val dao: ArenaDao

    companion object {
        @Volatile
        private var INSTANCE: ArenaDb? = null

        fun getInstance(context: Context): ArenaDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ArenaDb::class.java,
                        "arena.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}