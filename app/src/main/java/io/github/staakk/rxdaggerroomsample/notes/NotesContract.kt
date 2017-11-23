package io.github.staakk.rxdaggerroomsample.notes

import io.github.staakk.rxdaggerroomsample.data.model.Note

/**
 * Created 17.11.2017.
 */
interface NotesContract {

    interface View {
        fun isActive(): Boolean
        fun showNotes(notes: List<Note>)
    }

    interface Presenter {
        fun takeView(view: View)
        fun subscribe()
        fun unsubscribe()
        fun loadNotes()
    }

}