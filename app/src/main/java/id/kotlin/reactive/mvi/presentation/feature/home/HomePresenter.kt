package id.kotlin.reactive.mvi.presentation.feature.home

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import id.kotlin.reactive.mvi.data.interactor.HomeInteractor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class HomePresenter(
        private val interactor: HomeInteractor
) : MviBasePresenter<HomeView, HomeViewState>() {

    override fun bindIntents() {
        val homeViewState: Observable<HomeViewState> =
                intent(HomeView::findAllSport).flatMap {
                    interactor.getSports()
                }.observeOn(AndroidSchedulers.mainThread())
        subscribeViewState(homeViewState, HomeView::render)
    }
}