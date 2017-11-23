package io.github.staakk.rxdaggerroomsample.data

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created 18.11.2017.
 */

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app-database").build()
    }

    @Singleton
    @Provides
    fun noteDao(database: AppDatabase): NoteDao {
        return database.noteDao()
    }
}