package id.kotlin.reactive.mvi.presentation.feature.home

import id.kotlin.reactive.mvi.data.repository.remote.Response

sealed class HomeViewState {
    object LoadingState : HomeViewState()
    data class DataState(val response: Response) : HomeViewState()
    data class ErrorState(val throwable: Throwable) : HomeViewState()
}