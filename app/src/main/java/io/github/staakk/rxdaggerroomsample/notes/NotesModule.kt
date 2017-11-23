package io.github.staakk.rxdaggerroomsample.notes

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.staakk.rxdaggerroomsample.di.scope.ActivityScope
import io.github.staakk.rxdaggerroomsample.di.scope.FragmentScope

/**
 * Created 17.11.2017.
 */

@Module
abstract class NotesModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun notesFragment(): NotesFragment

    @ActivityScope
    @Binds
    abstract fun notesPresenter(presenter: NotesPresenter): NotesContract.Presenter


}