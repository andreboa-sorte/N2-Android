package com.example.listatelefonican2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    public static int CADATRADO_SUCESSO = 12;
    public static int CONSULTAR_SUCESSO = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSalvar = findViewById(R.id.salvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent (MainActivity.this, CadastroActivity.class);
                startActivityForResult(intentVaiProFormulario, CADATRADO_SUCESSO);

            }
        });

        Button btListar = findViewById(R.id.listar);
        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent (MainActivity.this, ConsultaActivity.class);
                startActivityForResult(intentVaiProFormulario, CONSULTAR_SUCESSO);

            }
        });
    }
}
