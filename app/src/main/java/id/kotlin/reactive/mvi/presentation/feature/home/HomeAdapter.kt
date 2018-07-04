package id.kotlin.reactive.mvi.presentation.feature.home

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import id.kotlin.reactive.mvi.R
import id.kotlin.reactive.mvi.data.repository.remote.Sport
import id.kotlin.reactive.mvi.inflate
import id.kotlin.reactive.mvi.load
import id.kotlin.reactive.mvi.presentation.feature.home.HomeAdapter.HomeHolder
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(
        private val listener: HomeListener,
        private val data: List<Sport>
) : Adapter<HomeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder =
            HomeHolder(parent.inflate(parent.context, R.layout.item_home, false))

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.bindView(data[holder.adapterPosition])
    }

    override fun getItemCount(): Int = data.size

    inner class HomeHolder(itemView: View) : ViewHolder(itemView) {

        fun bindView(data: Sport) {
            with(data) {
                itemView.image_sport.load(data.strSportThumb)
                itemView.text_title.text = data.strSport
                itemView.rootView.setOnClickListener { listener.onClick(data) }
            }
        }
    }

    interface HomeListener {

        fun onClick(data: Sport)
    }
}