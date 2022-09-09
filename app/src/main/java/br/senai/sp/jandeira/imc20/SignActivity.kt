package br.senai.sp.jandeira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.senai.sp.jandeira.imc20.model.User

class SignActivity : AppCompatActivity() {

    lateinit var editName: EditText;
    lateinit var editEmail: EditText;
    lateinit var editPassword: EditText;
    lateinit var editWeight: EditText;
    lateinit var editHeight: EditText;
    lateinit var buttonSave: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)


        supportActionBar!!.hide();

        //Instanciar os componentes(views)
        editName = findViewById(R.id.editTexName);
        editEmail = findViewById(R.id.editTexEmail);
        editPassword = findViewById(R.id.editTexPasswords);
        editWeight = findViewById(R.id.editTextWeight);
        editHeight = findViewById(R.id.editTextHeight);
        buttonSave = findViewById(R.id.buttonUserCreate);

        // Colocar click no botao
        buttonSave.setOnClickListener {
            saveUser()
        }

    }

    private fun saveUser() {
        val user = User()
        user.id = 1;
        user.name = editName.text.toString();
        user.email = editEmail.text.toString();
        user.password = editPassword.text.toString();
        user.weight = editWeight.text.toString().toDouble();
        user.height = editHeight.text.toString().toDouble();

        // Gravar o usuario no SharedPreferences
        // Step 1 - Obter uma instancia do SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE);

        // Step 2 - Criar um editor para o arquivo
        val editor = dados.edit();

        // Step 3 - Inserir os dados no arquivo
        editor.putInt("id", user.id);
        editor.putString("name", user.name);
        editor.putString("email", user.email);
        editor.putString("password", user.password);
        editor.putFloat("weight", user.weight.toString().toFloat());
        editor.putFloat("height", user.height.toString().toFloat())

        if(editor.commit()){
            Toast.makeText(this, "Usuario gravado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }else{
            Toast.makeText(this, "OCORREU UM ERRO NO CADASTRO!", Toast.LENGTH_SHORT).show()
        }

    }
}