package io.github.staakk.rxdaggerroomsample.addeditnote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.github.staakk.rxdaggerroomsample.R
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

fun Context.addEditNoteActivityIntent(noteId: Long): Intent {
    return Intent(this, AddEditNoteActivity::class.java).apply {
        putExtra(AddEditNoteActivity.EXTRA_NOTE_ID, noteId)
    }
}

fun Context.addEditNoteActivityIntent(): Intent {
    return Intent(this, AddEditNoteActivity::class.java)
}

class AddEditNoteActivity : DaggerAppCompatActivity() {

    companion object {
        const val EXTRA_NOTE_ID = "note_id"
    }

    @Inject
    lateinit var addEditNoteFragmentProvider: dagger.Lazy<AddEditNoteFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null) {
            fragment = addEditNoteFragmentProvider.get()

            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit()
        }
    }
}
