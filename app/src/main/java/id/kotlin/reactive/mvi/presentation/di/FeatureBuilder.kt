package id.kotlin.reactive.mvi.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.reactive.mvi.presentation.feature.detail.DetailActivity
import id.kotlin.reactive.mvi.presentation.feature.detail.DetailModule
import id.kotlin.reactive.mvi.presentation.feature.home.HomeActivity
import id.kotlin.reactive.mvi.presentation.feature.home.HomeModule

@Module
abstract class FeatureBuilder {

    @PerFeature
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindHomeActivity(): HomeActivity

    @PerFeature
    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun bindDetailActivity(): DetailActivity
}