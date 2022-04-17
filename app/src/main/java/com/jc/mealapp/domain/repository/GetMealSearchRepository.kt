package com.jc.mealapp.domain.repository

import com.jc.mealappcleanarchitecture.data.model.MealsDTO

interface GetMealSearchRepository {
    suspend fun getMealSearchList(s : String) : MealsDTO
}