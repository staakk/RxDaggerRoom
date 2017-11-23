package io.github.staakk.rxdaggerroomsample.util.scheduler

import io.reactivex.Scheduler

/**
 * Created 22.11.2017.
 */
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

}