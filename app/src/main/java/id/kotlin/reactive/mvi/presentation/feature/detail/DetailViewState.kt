package id.kotlin.reactive.mvi.presentation.feature.detail

import id.kotlin.reactive.mvi.data.repository.local.Sport

sealed class DetailViewState {
    data class DataState(val sport: Sport) : DetailViewState()
    data class ErrorState(val throwable: Throwable) : DetailViewState()
}