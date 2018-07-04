package id.kotlin.reactive.mvi.data.repository.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sport(val title: String,
                 val description: String,
                 val image: String) : Parcelable