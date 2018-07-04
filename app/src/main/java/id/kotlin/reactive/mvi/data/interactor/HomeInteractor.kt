package id.kotlin.reactive.mvi.data.interactor

import id.kotlin.reactive.mvi.data.repository.NetworkService
import id.kotlin.reactive.mvi.presentation.feature.home.HomeViewState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class HomeInteractor(private val service: NetworkService) {

    fun getSports(): Observable<HomeViewState> =
            service.getSports()
                   .map { HomeViewState.DataState(it) as HomeViewState }
                   .startWith(HomeViewState.LoadingState)
                   .onErrorReturn { HomeViewState.ErrorState(it) }
                   .subscribeOn(Schedulers.io())
}