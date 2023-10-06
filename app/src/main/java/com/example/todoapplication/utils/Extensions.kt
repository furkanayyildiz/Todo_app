package com.example.todoapplication.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.viewNavigate (view : View, id : Int){
    findNavController(view).navigate(id)
}
fun Navigation.viewNavigate (view : View, id : NavDirections){
    findNavController(view).navigate(id)
}