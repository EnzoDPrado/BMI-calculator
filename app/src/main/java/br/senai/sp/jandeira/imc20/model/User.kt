package br.senai.sp.jandeira.imc20.model

import kotlin.math.pow

class User {
    var id = 0;
    var name = "";
    var email = "";
    var password = "";
    var weight = 0.00;
    var height = 0.00;

    fun getBmi(): Double{
        return weight / height.pow(2)
    }








}