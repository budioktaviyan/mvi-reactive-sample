package id.kotlin.reactive.mvi.presentation.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import id.kotlin.reactive.mvi.App
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    FeatureBuilder::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}