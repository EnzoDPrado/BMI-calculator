package br.senai.sp.jandeira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandeira.imc20.databinding.ActivityBmiCalculator2Binding
import br.senai.sp.jandeira.imc20.databinding.ActivityMainBinding
import br.senai.sp.jandeira.imc20.databinding.ActivityResultBinding
import br.senai.sp.jandeira.imc20.utils.getBmi
import br.senai.sp.jandeira.imc20.utils.getBmiStatus


class ResultsActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //Recuperar valores que estao na intent
        val peso = intent.getStringExtra("peso").toString().toInt()
        val altura = intent.getStringExtra("altura").toString().toDouble()

        val resetAltura = altura / 100;

        val bmi = getBmi(peso, resetAltura)

        binding.textViewResult.text = String.format("%.2f", bmi)

        val status = getBmiStatus(bmi);

        binding.textViewStatus.text = status;





    }



}