package br.senai.sp.jandeira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.jandeira.imc20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binding.root);
        supportActionBar!!.hide();



        val openSingUpActivity = Intent(this, SignActivity::class.java)


        binding.singupTextView.setOnClickListener{
            startActivity(openSingUpActivity)
        }

        binding.buttonSignActivity.setOnClickListener {
            login()
        }



    }

    private fun login() {
        if(validar()){
            val email = binding.editTextEmail.text.toString();
            val pass =binding.editTextPassword.text.toString();

            val dados = getSharedPreferences("dados", MODE_PRIVATE);

            val emailSp = dados.getString("email", "E-mail nao encontrado");
            val passSp = dados.getString("password", "Senha nao encontrada");

            //Verificar se os dados de autenticacao estao corretos
            if(email == emailSp && pass == passSp){
                val openCalculate = Intent(this, BmiCalculator::class.java);
                startActivity(openCalculate);
            }else{
                Toast.makeText(this,"Authentication failed!",Toast.LENGTH_SHORT).show()
            }


        }



    }

    private fun validar(): Boolean {
    if (binding.editTextEmail.text.isEmpty()){
        binding.editTextEmail.error = "E-mail is required!"
        return false
    }
        if(binding.editTextPassword.text.isEmpty()){
            binding.editTextPassword.error = "Password is required";
            return false

        }

        return  true
    }
}