package com.jc.mealapp.data.repository

import com.jc.mealapp.data.remote.MealSeachAPI
import com.jc.mealapp.domain.repository.GetMealSearchRepository
import com.jc.mealappcleanarchitecture.data.model.MealsDTO

class GetMealSearchRepositoryIMP(private val mealSeachAPI: MealSeachAPI) : GetMealSearchRepository {
    override suspend fun getMealSearchList(s: String): MealsDTO {
        return mealSeachAPI.getMealList(s)
    }
}