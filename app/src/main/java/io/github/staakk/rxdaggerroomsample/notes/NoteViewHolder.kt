package io.github.staakk.rxdaggerroomsample.notes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.staakk.rxdaggerroomsample.R
import io.github.staakk.rxdaggerroomsample.data.model.Note

/**
 * Created 17.11.2017.
 */
class NoteViewHolder(
        view: View,
        val listener: NotesFragment.OnNoteClickListener)
    : RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener({
            if (note != null) {
                listener.onNoteClicked(note!!)
            }
        })
    }

    var note: Note? = null

    companion object {

        fun create(parent: ViewGroup, listener: NotesFragment.OnNoteClickListener): NoteViewHolder {
            return NoteViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false),
                    listener)
        }

    }

    private val title: TextView = itemView.findViewById(R.id.title)
    private val text: TextView = itemView.findViewById(R.id.text)

    fun bind(note: Note) {
        this.note = note
        title.text = note.title
        text.text = note.text
    }
}