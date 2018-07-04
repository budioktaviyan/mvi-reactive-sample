package id.kotlin.reactive.mvi.data.repository.remote

import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("sports") val sports: List<Sport>)

data class Sport(
        @SerializedName("idSport") val idSport: String,
        @SerializedName("strSport") val strSport: String,
        @SerializedName("strSportThumb") val strSportThumb: String,
        @SerializedName("strSportDescription") val strSportDescription: String
)