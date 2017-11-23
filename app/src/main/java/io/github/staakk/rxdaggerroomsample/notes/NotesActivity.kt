package io.github.staakk.rxdaggerroomsample.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity
import io.github.staakk.rxdaggerroomsample.R
import io.github.staakk.rxdaggerroomsample.addeditnote.addEditNoteActivityIntent
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

fun Context.notesIntent(): Intent {
    return Intent(this, NotesActivity::class.java)
}

class NotesActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var notesFragmentProvider: dagger.Lazy<NotesFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setSupportActionBar(toolbar)

        var notesFragment: NotesFragment?
                = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NotesFragment?

        if (notesFragment == null) {
            notesFragment = notesFragmentProvider.get()
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, notesFragment)
                    .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.notes_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item == null) return super.onOptionsItemSelected(item)

        when (item.itemId) {
            R.id.add_note -> {
                startActivity(addEditNoteActivityIntent())
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
