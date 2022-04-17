package com.jc.mealapp.persentation.meal_search

import com.jc.mealapp.domain.model.Meal

data class MealSearchState(
    val data : List<Meal>? = null,
    val error: String = "",
    val isLoading : Boolean = false,
)
