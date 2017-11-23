package io.github.staakk.rxdaggerroomsample.addeditnote

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.github.staakk.rxdaggerroomsample.di.scope.ActivityScope
import io.github.staakk.rxdaggerroomsample.di.scope.FragmentScope
import java.util.*
import javax.inject.Named

/**
 * Created 18.11.2017.
 */

@Module
abstract class AddEditNoteModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun addEditNoteFragment() : AddEditNoteFragment

    @ActivityScope
    @Binds
    abstract fun addEditNotePresenter(presenter: AddEditNotePresenter) : AddEditNoteContract.Presenter

    @Module
    companion object {

        @ActivityScope
        @Provides
        @Named(AddEditNoteActivity.EXTRA_NOTE_ID)
        @JvmStatic
        fun provideNoteId(notesActivity: AddEditNoteActivity): Long? {
            val noteId = notesActivity.intent.getLongExtra(AddEditNoteActivity.EXTRA_NOTE_ID, -1L)
            if (noteId == -1L) return null
            return noteId
        }
    }

}