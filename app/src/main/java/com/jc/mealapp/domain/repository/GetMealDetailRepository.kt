package com.jc.mealapp.domain.repository

import com.jc.mealappcleanarchitecture.data.model.MealsDTO

interface GetMealDetailRepository {
    suspend fun getMealDetails(id : String) : MealsDTO
}