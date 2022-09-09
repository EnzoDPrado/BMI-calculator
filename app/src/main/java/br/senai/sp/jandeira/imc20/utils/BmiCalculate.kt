package br.senai.sp.jandeira.imc20.utils

import kotlin.math.pow

fun getBmi(weight: Int, height: Double ): Double{
    return weight / height.pow(2);
}


fun getBmiStatus(bmi: Double): String{

    if(bmi <= 18.5) {
        return "Abaixo do peso"
    }else if (bmi >= 18.6 && bmi <= 24.9){
        return "Peso ideal! Parabens"
    }else if(bmi >= 25.0 && bmi <= 29.9){
        return "Levemente acima do peso"
    }else if(bmi >= 30.0 && bmi <= 34.9){
        return "Obesidade grau I"
    }else if(bmi >= 35.0 && bmi <= 39.9){
        return "Obesidade grau II (SEVERA)"
    }else{
        return "Obesidade III (MORBIDA)"
    }
}