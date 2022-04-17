package com.jc.mealapp.data.remote

import com.jc.mealappcleanarchitecture.data.model.MealsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MealSeachAPI {

    @GET("api/json/v1/1/search.php")
    suspend fun getMealList(@Query("s") s : String) : MealsDTO

    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetail(@Query("i") s : String) : MealsDTO
}