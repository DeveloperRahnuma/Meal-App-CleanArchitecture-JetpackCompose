package com.jc.mealapp.persentation.meal_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jc.mealapp.common.ResourceState
import com.jc.mealapp.domain.use_case.GetMealSearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MealSearchViewModel @Inject constructor(val getMealSearchListUseCase: GetMealSearchListUseCase): ViewModel() {

    val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
    //val mealSearchList : StateFlow<MealSearchState> = _mealSearchList


    fun searchMealList(s : String){
        getMealSearchListUseCase(s).onEach {
            when(it){
                is ResourceState.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                is ResourceState.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
                is ResourceState.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}