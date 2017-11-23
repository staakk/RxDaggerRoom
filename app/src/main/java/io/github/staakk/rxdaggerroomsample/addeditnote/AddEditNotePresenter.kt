package io.github.staakk.rxdaggerroomsample.addeditnote

import io.github.staakk.rxdaggerroomsample.data.NoteRepository
import io.github.staakk.rxdaggerroomsample.data.model.Note
import io.github.staakk.rxdaggerroomsample.util.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

/**
 * Created 18.11.2017.
 */
class AddEditNotePresenter
@Inject
constructor(
        @Named(AddEditNoteActivity.EXTRA_NOTE_ID) noteId: Long?,
        val schedulerProvider: SchedulerProvider,
        val noteRepository: NoteRepository
)
    : AddEditNoteContract.Presenter {

    val noteId: Long? = noteId
    var view: AddEditNoteContract.View? = null
    val disposable = CompositeDisposable()

    override fun subscribe() {
        if (!isNewNote()) {
            populateNote()
        }
    }

    override fun unsubscribe() {
        disposable.clear()
    }

    private fun populateNote() {
        val id = checkNotNull(noteId) { "populate was called for not existing note" }
        disposable.add(
                noteRepository.findById(id)
                        .observeOn(schedulerProvider.ui())
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(
                                {
                                    val view = checkNotNull(view)
                                    if (view.isActive()) {
                                        view.showTitle(it.title)
                                        view.showText(it.text)
                                    }
                                },
                                {
                                    val view = checkNotNull(view)
                                    if (view.isActive()) {
                                        view.showErrorLoadingNote()
                                    }
                                }
                        )
        )
    }

    override fun takeView(view: AddEditNoteContract.View) {
        this.view = view
    }

    override fun saveNote(title: String, text: String) {
        if (isNewNote()) {
            createNote(title, text)
        } else {
            updateNote(title, text)
        }
    }

    fun createNote(title: String, text: String) {
        disposable.add(noteRepository.insertAll(Note(title = title, text = text))
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                        {
                            val view = checkNotNull(view)
                            if (view.isActive()) {
                                view.onNoteCreateSuccess()
                            }
                        },
                        {
                            val view = checkNotNull(view)
                            if (view.isActive()) {
                                view.showErrorCreatingNote()
                            }
                        }
                )
        )
    }

    fun updateNote(title: String, text: String) {
        val id = checkNotNull(noteId) { "update note called with null noteId" }
        noteRepository.update(Note(id, title, text))
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                        { view?.onNoteUpdateSuccess() },
                        { view?.showErrorUpdatingNote() }
                )
    }

    fun isNewNote() = noteId == null

}