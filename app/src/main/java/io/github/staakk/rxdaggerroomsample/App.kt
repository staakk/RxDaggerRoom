package io.github.staakk.rxdaggerroomsample

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.staakk.rxdaggerroomsample.di.DaggerAppComponent


/**
 * Created 17.11.2017.
 */

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()

        appComponent.inject(this)
        return appComponent
    }

}