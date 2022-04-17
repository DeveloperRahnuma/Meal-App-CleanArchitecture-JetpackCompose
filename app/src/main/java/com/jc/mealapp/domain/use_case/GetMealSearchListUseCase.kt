package com.jc.mealapp.domain.use_case

import com.jc.mealapp.common.ResourceState
import com.jc.mealapp.domain.model.Meal
import com.jc.mealapp.domain.repository.GetMealSearchRepository
import com.jc.mealappcleanarchitecture.data.model.toDomainMeal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMealSearchListUseCase @Inject constructor(private val getMealSearchRepository: GetMealSearchRepository) {
    operator fun invoke(s : String) : Flow<ResourceState<List<Meal>>> = flow {
        try {
            emit(ResourceState.Loading())
            val responce = getMealSearchRepository.getMealSearchList(s)
            val list = if (responce.meals.isNullOrEmpty()) emptyList<Meal>() else responce.meals.map { it.toDomainMeal() }
            emit(ResourceState.Success(list))
        }catch (e : Exception){
            emit(ResourceState.Error(e.message.toString()))
        }
    }
}