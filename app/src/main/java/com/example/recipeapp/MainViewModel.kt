package com.example.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private  val _categoricalState = mutableStateOf(Recipestate())
    val categoriesState:State<Recipestate> = _categoricalState

    init {
        fetchCateories()
    }

    private fun fetchCateories(){
        viewModelScope.launch {
            try {
                val response= recipeService.getCategories()
                _categoricalState.value=_categoricalState.value.copy(loading = false,list = response.categories,error = null)


            }catch (e:Exception){
                _categoricalState.value=_categoricalState.value
                    .copy(loading = false, error("Error fetching categories ${e.message}"))

            }
        }

    }

    data class Recipestate(val loading:Boolean=true,
        val list:List<Category> = emptyList(),
        val error:String? = null
    )


}