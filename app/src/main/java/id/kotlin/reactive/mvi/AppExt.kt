package id.kotlin.reactive.mvi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.kotlin.reactive.mvi.presentation.glide.GlideApp

internal inline fun <reified T : Any> clazz() = T::class.java

internal fun ImageView.load(url: String) {
    val context = this.context
    Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL)
    GlideApp.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(this)
}

internal fun ViewGroup?.inflate(context: Context,
                                layoutRes: Int,
                                attachToRoot: Boolean): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)