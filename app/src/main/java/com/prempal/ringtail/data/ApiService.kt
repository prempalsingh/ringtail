package com.prempal.ringtail.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by prempal on 3/2/20.
 */
interface ApiService {

    @GET("pulls?state=closed")
    suspend fun getClosedPRs(
        @Query("page") page: Int
    ): Response<List<PullRequest>>
}
