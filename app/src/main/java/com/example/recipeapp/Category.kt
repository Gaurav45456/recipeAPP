package com.example.recipeapp
@Parcelize
data class Category(val idCategory:String,
                    val strCategory:String,
                    val strCategoryThumb:String,
                    val strCategoryDescription:String)

data class CategoriesResponse(val categories:List<Category>)

