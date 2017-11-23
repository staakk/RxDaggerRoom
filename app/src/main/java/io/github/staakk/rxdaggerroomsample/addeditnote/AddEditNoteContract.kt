package io.github.staakk.rxdaggerroomsample.addeditnote

/**
 * Created 18.11.2017.
 */
interface AddEditNoteContract {

    interface View {
        fun isActive(): Boolean
        fun showTitle(title: String)
        fun showText(text: String)
        fun showErrorLoadingNote()
        fun showErrorCreatingNote()
        fun showErrorUpdatingNote()
        fun onNoteCreateSuccess()
        fun onNoteUpdateSuccess()
    }

    interface Presenter {
        fun takeView(view: View)
        fun subscribe()
        fun unsubscribe()
        fun saveNote(title: String, text: String)
    }

}