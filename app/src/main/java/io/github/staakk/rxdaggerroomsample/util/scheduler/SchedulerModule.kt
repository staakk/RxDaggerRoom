package io.github.staakk.rxdaggerroomsample.util.scheduler

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created 22.11.2017.
 */

@Module
abstract class SchedulerModule {

    @Singleton
    @Binds
    abstract fun schedulerProvider(provider: SchedulerProviderImpl): SchedulerProvider

}