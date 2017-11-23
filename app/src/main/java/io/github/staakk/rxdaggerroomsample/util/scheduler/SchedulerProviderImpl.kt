package io.github.staakk.rxdaggerroomsample.util.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created 22.11.2017.
 */
@Singleton
class SchedulerProviderImpl @Inject constructor(): SchedulerProvider {

    override fun computation() = Schedulers.computation()

    override fun io() = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

}