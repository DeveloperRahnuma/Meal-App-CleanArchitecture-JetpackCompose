package com.jc.mealapp.data.repository

import com.jc.mealapp.data.remote.MealSeachAPI
import com.jc.mealapp.domain.repository.GetMealDetailRepository
import com.jc.mealappcleanarchitecture.data.model.MealsDTO

class GetMealDetailRepositoryIMP(private val mealSeachAPI: MealSeachAPI) : GetMealDetailRepository {
    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealSeachAPI.getMealDetail(id)
    }
}