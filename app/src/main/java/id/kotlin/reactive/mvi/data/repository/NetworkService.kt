package id.kotlin.reactive.mvi.data.repository

import id.kotlin.reactive.mvi.data.repository.remote.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkService {

    @GET("/api/v1/json/1/all_sports.php")
    fun getSports(): Observable<Response>
}