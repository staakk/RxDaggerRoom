package io.github.staakk.rxdaggerroomsample.data

import io.github.staakk.rxdaggerroomsample.data.model.Note
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created 18.11.2017.
 */
interface NoteRepository {

    fun getAll(): Flowable<List<Note>>

    fun findById(noteId: Long): Flowable<Note>

    fun insertAll(vararg notes: Note): Completable

    fun update(vararg notes: Note): Completable

    fun delete(note: Note): Completable

}