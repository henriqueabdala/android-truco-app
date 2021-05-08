package com.ghostapps.trucoscore.data.records.local

import androidx.room.*
import com.ghostapps.trucoscore.data.records.RecordEntity

@Database(entities = [RecordEntity::class], version = 1)
abstract class RecordDatabase: RoomDatabase() {
    abstract fun recordDao(): RecordDao
}