package io.github.staakk.rxdaggerroomsample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.staakk.rxdaggerroomsample.addeditnote.AddEditNoteActivity
import io.github.staakk.rxdaggerroomsample.addeditnote.AddEditNoteContract
import io.github.staakk.rxdaggerroomsample.addeditnote.AddEditNoteModule
import io.github.staakk.rxdaggerroomsample.di.scope.ActivityScope
import io.github.staakk.rxdaggerroomsample.notes.NotesActivity
import io.github.staakk.rxdaggerroomsample.notes.NotesModule

/**
 * Created 17.11.2017.
 */

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(NotesModule::class))
    abstract fun notesActivity(): NotesActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(AddEditNoteModule::class))
    abstract fun addEditNoteActivity(): AddEditNoteActivity

}