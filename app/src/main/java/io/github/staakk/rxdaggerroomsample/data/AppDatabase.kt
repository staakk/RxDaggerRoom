package io.github.staakk.rxdaggerroomsample.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.github.staakk.rxdaggerroomsample.data.model.Note

/**
 * Created 18.11.2017.
 */
@Database(entities = arrayOf(Note::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}