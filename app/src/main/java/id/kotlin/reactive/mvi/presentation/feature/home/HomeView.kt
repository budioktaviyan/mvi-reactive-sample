package id.kotlin.reactive.mvi.presentation.feature.home

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface HomeView : MvpView {

    fun findAllSport(): Observable<HomeViewState>
    fun render(state: HomeViewState)
}