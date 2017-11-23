package io.github.staakk.rxdaggerroomsample.util.scheduler

import io.reactivex.schedulers.Schedulers

/**
 * Created 22.11.2017.
 */
class SchedulerProviderTestImpl: SchedulerProvider {

    override fun computation() = Schedulers.trampoline()

    override fun io() = Schedulers.trampoline()

    override fun ui() = Schedulers.trampoline()

}