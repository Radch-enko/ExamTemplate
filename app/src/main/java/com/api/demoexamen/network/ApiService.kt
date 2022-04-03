package com.api.demoexamen.network

import com.api.demoexamen.models.ActivityResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    @GET("activity")
    fun getActivity(): Single<ActivityResponse>
}