package io.github.staakk.rxdaggerroomsample.data

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created 18.11.2017.
 */
@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun noteRepository(repo: NoteRepositoryImpl) : NoteRepository

}