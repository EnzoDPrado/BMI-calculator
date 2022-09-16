package br.senai.sp.jandeira.imc20.utils

import android.content.Context
import br.senai.sp.jandeira.imc20.R
import kotlin.math.pow

fun getBmi(weight: Int, height: Double ): Double{
    return weight / height.pow(2);
}


fun getBmiStatus(bmi: Double, context:Context): String{

    if(bmi <= 18.5) {
        return context.getString(R.string.under_weight);
    }else if (bmi >= 18.6 && bmi <= 24.9){
        return context.getString(R.string.ideal_weight);
    }else if(bmi >= 25.0 && bmi <= 29.9){
        return context.getString(R.string.overweight);
    }else if(bmi >= 30.0 && bmi <= 34.9){
        return context.getString(R.string.obesity_one);
    }else if(bmi >= 35.0 && bmi <= 39.9){
        return context.getString(R.string.obesity_two);
    }else{
        return context.getString(R.string.obesity_three);
    }
}