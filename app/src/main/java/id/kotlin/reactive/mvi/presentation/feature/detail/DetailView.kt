package id.kotlin.reactive.mvi.presentation.feature.detail

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface DetailView : MvpView {

    fun showSport(): Observable<DetailViewState>
    fun render(state: DetailViewState)
}