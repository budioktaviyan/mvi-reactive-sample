package id.kotlin.reactive.mvi.presentation.feature.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.toast
import com.hannesdorfmann.mosby3.mvi.MviActivity
import dagger.android.AndroidInjection
import id.kotlin.reactive.mvi.R
import id.kotlin.reactive.mvi.clazz
import id.kotlin.reactive.mvi.data.repository.remote.Sport
import id.kotlin.reactive.mvi.presentation.feature.detail.DetailActivity
import id.kotlin.reactive.mvi.presentation.feature.home.HomeAdapter.HomeListener
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject
import id.kotlin.reactive.mvi.data.repository.local.Sport as Model

class HomeActivity : MviActivity<HomeView, HomePresenter>(), HomeView, HomeListener {

    @Inject lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar_home)
    }

    override fun createPresenter(): HomePresenter = presenter
    override fun findAllSport(): Observable<HomeViewState> =
            Observable.just(HomeViewState.LoadingState)

    override fun render(state: HomeViewState) =
            when (state) {
                is HomeViewState.LoadingState -> {
                    pb_home.visibility = View.VISIBLE
                    rv_home.visibility = View.GONE
                }
                is HomeViewState.DataState -> {
                    pb_home.visibility = View.GONE
                    rv_home.visibility = View.VISIBLE

                    val data = state.response.sports
                    val adapter = HomeAdapter(this, data)
                    rv_home.adapter = adapter
                }
                is HomeViewState.ErrorState -> {
                    pb_home.visibility = View.GONE
                    rv_home.visibility = View.GONE

                    toast("Something went wrong...").show()
                }
            }

    override fun onClick(data: Sport) {
        val model = Model(
                title = data.strSport,
                description = data.strSportDescription,
                image = data.strSportThumb
        )

        Intent(this, clazz<DetailActivity>()).apply {
            putExtra("MODEL", model)
        }.apply { startActivity(this) }
    }
}