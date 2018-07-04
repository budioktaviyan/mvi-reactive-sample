package id.kotlin.reactive.mvi.presentation.feature.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.core.widget.toast
import com.hannesdorfmann.mosby3.mvi.MviActivity
import dagger.android.AndroidInjection
import id.kotlin.reactive.mvi.R
import id.kotlin.reactive.mvi.data.repository.local.Sport
import id.kotlin.reactive.mvi.load
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : MviActivity<DetailView, DetailPresenter>(), DetailView {

    @Inject lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar_detail)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun createPresenter(): DetailPresenter = presenter
    override fun showSport(): Observable<DetailViewState> {
        val model = intent.getParcelableExtra<Sport>("MODEL")
        return Observable.just(DetailViewState.DataState(model))
    }

    override fun render(state: DetailViewState) =
            when (state) {
                is DetailViewState.DataState -> {
                    toolbar_detail.title = state.sport.title
                    image_detail.load(state.sport.image)
                    text_description.text = state.sport.description
                }
                is DetailViewState.ErrorState -> {
                    toast("Something went wrong...").show()
                }
            }
}