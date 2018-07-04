package id.kotlin.reactive.mvi.presentation.feature.detail

import dagger.Module
import dagger.Provides
import id.kotlin.reactive.mvi.presentation.di.PerFeature

@Module
class DetailModule {

    @Provides
    @PerFeature
    fun providesDetailPresenter() = DetailPresenter()
}