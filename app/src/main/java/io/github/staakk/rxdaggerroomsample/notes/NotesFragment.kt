package io.github.staakk.rxdaggerroomsample.notes

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import io.github.staakk.rxdaggerroomsample.R
import io.github.staakk.rxdaggerroomsample.addeditnote.addEditNoteActivityIntent
import io.github.staakk.rxdaggerroomsample.data.model.Note
import io.github.staakk.rxdaggerroomsample.di.scope.ActivityScope
import kotlinx.android.synthetic.main.fragment_notes.*
import javax.inject.Inject

/**
 * Created 17.11.2017.
 */

@ActivityScope
class NotesFragment @Inject constructor() : DaggerFragment(), NotesContract.View {

    private val onNoteClickListener = object : OnNoteClickListener {
        override fun onNoteClicked(note: Note) {
            val id = checkNotNull(note.id) { "note id cannot be null" }
            startActivity(context.addEditNoteActivityIntent(id))
        }
    }

    @Inject
    lateinit var presenter: NotesContract.Presenter

    private val notesAdapter = NotesAdapter(onNoteClickListener)

    override fun onResume() {
        super.onResume()
        presenter.takeView(this)
        presenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter.unsubscribe()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesList.layoutManager = LinearLayoutManager(context)
        notesList.adapter = notesAdapter
    }

    override fun showNotes(notes: List<Note>) {
        notesAdapter.setNotes(notes)
    }

    override fun isActive() = isAdded

    interface OnNoteClickListener {
        fun onNoteClicked(note: Note)
    }

}