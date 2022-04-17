package com.jc.mealapp.persentation

sealed class MealScreen(val route : String){
    object MealSearchScreen: MealScreen("notes_screen")
    object MealDetailScreen: MealScreen("add_edit_note_screen")
}
