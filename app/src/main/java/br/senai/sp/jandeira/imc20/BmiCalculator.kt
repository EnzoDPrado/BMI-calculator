package br.senai.sp.jandeira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandeira.imc20.databinding.ActivityBmiCalculator2Binding




class BmiCalculator : AppCompatActivity() {

    private lateinit var binding: ActivityBmiCalculator2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityBmiCalculator2Binding.inflate(layoutInflater)
            setContentView(binding.root)
            loadProfile()

            binding.buttonCalculate.setOnClickListener {bmiCalculate()}


        }

        private fun bmiCalculate(){
            val openResult = Intent(this, ResultsActivity::class.java)

            openResult.putExtra("peso", binding.editTextWeight.text.toString());
            openResult.putExtra("altura", binding.editTextHeight.text.toString());

            startActivity(openResult)
        }

        private fun loadProfile() {
            //Abrir o arquivo SharedPreferences
            val dados = getSharedPreferences("dados", MODE_PRIVATE) // referencia do shared preferences


            binding.textViewUsername.text = dados.getString("name", "");
            binding.textViewEmail.text = dados.getString("email", "");
            binding.textViewWeight.text = "Weight : ${dados.getFloat("weight", 0F)}Kg";
            binding.textViewHeight.text = "Height : ${dados.getFloat("height", 0F)}Cm"

        }

}