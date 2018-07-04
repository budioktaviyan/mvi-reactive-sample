package id.kotlin.reactive.mvi.presentation.feature.detail

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class DetailPresenter : MviBasePresenter<DetailView, DetailViewState>() {

    override fun bindIntents() {
        val detailViewState: Observable<DetailViewState> =
                intent(DetailView::showSport).observeOn(
                        AndroidSchedulers.mainThread()
                )
        subscribeViewState(detailViewState, DetailView::render)
    }
}