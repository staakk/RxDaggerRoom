package io.github.staakk.rxdaggerroomsample.notes

import io.github.staakk.rxdaggerroomsample.data.NoteRepository
import io.github.staakk.rxdaggerroomsample.di.scope.ActivityScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created 17.11.2017.
 */
@ActivityScope
class NotesPresenter @Inject constructor(val notesRepository: NoteRepository) : NotesContract.Presenter {

    val disposable = CompositeDisposable()
    var view: NotesContract.View? = null

    override fun takeView(view: NotesContract.View) {
        this.view = view
    }

    override fun subscribe() {
        loadNotes()
    }

    override fun unsubscribe() {
        disposable.clear()
    }

    override fun loadNotes() {
        disposable.add(
                notesRepository.getAll()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    val view = checkNotNull(view)
                                    if (view.isActive()) {
                                        view.showNotes(it)
                                    }
                                },
                                {}
                        )
        )
    }


}