package io.github.staakk.rxdaggerroomsample.data

import io.github.staakk.rxdaggerroomsample.data.model.Note
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created 18.11.2017.
 */
@Singleton
class NoteRepositoryImpl @Inject constructor(val noteDao: NoteDao) : NoteRepository {


    override fun insertAll(vararg notes: Note): Completable {
        return Completable.fromCallable { noteDao.insertAll(*notes) }
    }

    override fun update(vararg notes: Note): Completable {
        return Completable.fromCallable { noteDao.update(*notes) }
    }

    override fun delete(note: Note): Completable {
        return Completable.fromCallable { noteDao.delete(note) }
    }

    override fun getAll(): Flowable<List<Note>> {
        return noteDao.getAll()
    }

    override fun findById(noteId: Long): Flowable<Note> {
        return noteDao.findById(noteId)
    }

}