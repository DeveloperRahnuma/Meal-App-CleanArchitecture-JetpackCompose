package com.jc.mealapp.di

import com.jc.mealapp.common.BaseClass
import com.jc.mealapp.data.remote.MealSeachAPI
import com.jc.mealapp.data.repository.GetMealDetailRepositoryIMP
import com.jc.mealapp.data.repository.GetMealSearchRepositoryIMP
import com.jc.mealapp.domain.repository.GetMealDetailRepository
import com.jc.mealapp.domain.repository.GetMealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideMealSearchAPI() : MealSeachAPI{
        return Retrofit.Builder().baseUrl(BaseClass.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MealSeachAPI::class.java)
    }

    @Provides
    fun provideMealSearchRepository(mealSeachAPI: MealSeachAPI) : GetMealSearchRepository{
        return GetMealSearchRepositoryIMP(mealSeachAPI)
    }

    @Provides
    fun provideMealDetailRepository(mealSeachAPI: MealSeachAPI) : GetMealDetailRepository{
        return GetMealDetailRepositoryIMP(mealSeachAPI)
    }
}