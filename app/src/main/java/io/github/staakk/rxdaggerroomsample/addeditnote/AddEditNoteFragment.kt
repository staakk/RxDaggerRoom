package io.github.staakk.rxdaggerroomsample.addeditnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import io.github.staakk.rxdaggerroomsample.R
import io.github.staakk.rxdaggerroomsample.di.scope.ActivityScope
import kotlinx.android.synthetic.main.fragment_add_edit_note.*
import javax.inject.Inject

/**
 * Created 18.11.2017.
 */

@ActivityScope
class AddEditNoteFragment @Inject constructor(): DaggerFragment(), AddEditNoteContract.View {

    @Inject
    lateinit var preseneter : AddEditNoteContract.Presenter

    override fun isActive(): Boolean {
        return isAdded
    }

    override fun showTitle(title: String) {
        this.title.setText(title)
    }

    override fun showText(text: String) {
        this.text.setText(text)
    }

    override fun showErrorLoadingNote() {
        Toast.makeText(context, "Loading Error", Toast.LENGTH_LONG).show()
    }

    override fun showErrorCreatingNote() {
        Toast.makeText(context, "Creating Error", Toast.LENGTH_LONG).show()
    }

    override fun showErrorUpdatingNote() {
        Toast.makeText(context, "Updating Error", Toast.LENGTH_LONG).show()
    }

    override fun onNoteCreateSuccess() {
        Toast.makeText(context, "Note created", Toast.LENGTH_LONG).show()
    }

    override fun onNoteUpdateSuccess() {
        Toast.makeText(context, "Note updated", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        preseneter.takeView(this)
        preseneter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        preseneter.unsubscribe()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_add_edit_note, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        addNote.setOnClickListener {
            preseneter.saveNote(this.title.text.toString(), this.text.text.toString())
        }
    }
}