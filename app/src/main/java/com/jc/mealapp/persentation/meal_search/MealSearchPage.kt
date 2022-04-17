import android.annotation.SuppressLint
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jc.mealapp.persentation.meal_search.MealSearchViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.jc.mealapp.common.ResourceState
import com.jc.mealapp.domain.model.Meal
import com.jc.mealapp.persentation.MealScreen
import com.jc.mealapp.persentation.meal_search.MealSearchState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@Composable
fun MealSearchDataShow(
//    navController: NavController,
    mealSearchViewModel: MealSearchViewModel = hiltViewModel()
){
    val coroutineScope = rememberCoroutineScope()
//    Scaffold(
//        topBar = {TopBarDesign()}
//    ){
////    Column {
////            searchRowDesign(mealSearchViewModel)
////            coroutineScope.launch {
////
////            }
////      }
//
//
//
//    }

    coroutineScope.launch {
        mealSearchViewModel.mealSearchList.collect {
            it.data?.let { it1 -> designGrid(it1) }
        }
    }



}

@Composable
fun TopBarDesign(){
   TopAppBar(
       title = { Text("Meal Search App")},
       backgroundColor = MaterialTheme.colors.background
   )
}

@Composable
fun searchRowDesign(mealSearchViewModel: MealSearchViewModel){

    var textValue by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ){
        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            }
        )

        IconButton( onClick = {
            mealSearchViewModel.searchMealList(textValue)
        } ){
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = ""
            )
        }
    }
}


@Composable
fun designGrid(listOfMeal : List<Meal>){
    LazyColumn {
        items(listOfMeal.size){
            Box(modifier = Modifier.width(200.dp))
        }
    }
}

