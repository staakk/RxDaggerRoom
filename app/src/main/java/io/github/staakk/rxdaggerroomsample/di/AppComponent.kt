package io.github.staakk.rxdaggerroomsample.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import io.github.staakk.rxdaggerroomsample.App
import io.github.staakk.rxdaggerroomsample.data.DatabaseModule
import io.github.staakk.rxdaggerroomsample.data.RepositoriesModule
import io.github.staakk.rxdaggerroomsample.util.scheduler.SchedulerModule
import javax.inject.Singleton

/**
 * Created 19.10.2017.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DatabaseModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        SchedulerModule::class,
        RepositoriesModule::class
))
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: App)

    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent

    }


}