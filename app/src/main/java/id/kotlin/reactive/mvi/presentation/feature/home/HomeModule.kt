package id.kotlin.reactive.mvi.presentation.feature.home

import dagger.Module
import dagger.Provides
import id.kotlin.reactive.mvi.data.interactor.HomeInteractor
import id.kotlin.reactive.mvi.data.repository.NetworkService
import id.kotlin.reactive.mvi.presentation.di.PerFeature

@Module
class HomeModule {

    @Provides
    @PerFeature
    fun providesHomeInteractor(service: NetworkService) = HomeInteractor(service)

    @Provides
    @PerFeature
    fun providesHomePresenter(interactor: HomeInteractor) = HomePresenter(interactor)
}