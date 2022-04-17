package com.jc.mealapp.domain.use_case

import com.jc.mealapp.common.ResourceState
import com.jc.mealapp.domain.model.MealDetail
import com.jc.mealapp.domain.repository.GetMealDetailRepository
import com.jc.mealappcleanarchitecture.data.model.toDomainMealDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMealDetailUseCase @Inject constructor(private val getMealDetailRepository: GetMealDetailRepository) {
    operator fun invoke(id : String) : Flow<ResourceState<List<MealDetail>>> = flow {
        try {
            emit(ResourceState.Loading())
            val responce = getMealDetailRepository.getMealDetails(id).meals[0].toDomainMealDetails()
            emit(ResourceState.Success(listOf(responce)))
        }catch (e : Exception){
            emit(ResourceState.Error(e.message.toString()))
        }
    }
}