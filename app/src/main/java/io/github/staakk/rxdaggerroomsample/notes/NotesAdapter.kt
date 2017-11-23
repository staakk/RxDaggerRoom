package io.github.staakk.rxdaggerroomsample.notes

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup
import io.github.staakk.rxdaggerroomsample.data.model.Note

/**
 * Created 17.11.2017.
 */
class NotesAdapter(val listener: NotesFragment.OnNoteClickListener) : Adapter<NoteViewHolder>() {

    var notes = emptyList<Note>()

    override fun onBindViewHolder(holder: NoteViewHolder?, position: Int) {
        holder?.bind(notes[holder.adapterPosition])
    }

    override fun getItemCount() = notes.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NoteViewHolder {
        return NoteViewHolder.create(parent!!, listener)
    }

    internal fun setNotes(newNotes: List<Note>) {
        val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun getOldListSize() = notes.size

            override fun getNewListSize() = newNotes.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = notes[oldItemPosition]
                val newItem = newNotes[newItemPosition]
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = notes[oldItemPosition]
                val newItem = newNotes[newItemPosition]
                return oldItem == newItem
            }

        })
        this.notes = newNotes
        result.dispatchUpdatesTo(this)
    }


}