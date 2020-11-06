package com.example.listatelefonican2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText nome = (EditText)findViewById(R.id.editText);
                EditText numero = (EditText)findViewById((R.id.editText2));

                String nomeString = nome.getText().toString();
                String numeroString = numero.getText().toString();

                BancoController crud = new BancoController(getBaseContext());
                String resultado = crud.insereDado(nomeString,numeroString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}