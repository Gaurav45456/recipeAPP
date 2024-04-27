package com.example.recipeapp

sealed class Screen (val route:String){
    data object RecipeScreen:Screen(route = "recipescreen")
    data object DetailScreen:Screen(route = "detailscreen")

}