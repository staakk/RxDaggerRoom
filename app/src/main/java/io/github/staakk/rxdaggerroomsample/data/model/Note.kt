package io.github.staakk.rxdaggerroomsample.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created 17.11.2017.
 */

@Entity
data class Note(
        @PrimaryKey(autoGenerate = true)
        var id: Long? = null,
        @ColumnInfo(name = "title")
        var title: String,
        @ColumnInfo(name = "text")
        var text: String
)