package io.github.staakk.rxdaggerroomsample.data

import android.arch.persistence.room.*
import io.github.staakk.rxdaggerroomsample.data.model.Note
import io.reactivex.Flowable

/**
 * Created 18.11.2017.
 */
@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAll(): Flowable<List<Note>>

    @Query("SELECT * FROM note WHERE id=:noteId")
    fun findById(noteId: Long): Flowable<Note>

    @Insert
    fun insertAll(vararg notes: Note)

    @Update
    fun update(vararg notes: Note)

    @Delete
    fun delete(note: Note)
}