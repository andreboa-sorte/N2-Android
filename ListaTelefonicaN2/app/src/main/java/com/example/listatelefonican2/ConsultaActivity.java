package com.example.listatelefonican2;

import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ConsultaActivity extends AppCompatActivity {
    List<String> lista = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        getData();

        ListView listaAlunos = (ListView) findViewById(R.id.lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaAlunos.setAdapter(adapter);
    }

    private void getData() {
        BancoController crud = new BancoController(getBaseContext());
        Cursor c = crud.carregaDados();
        while(c.moveToNext()) {

            int index;


            index = c.getColumnIndexOrThrow("nome");
            String nome = c.getString(index);


            index = c.getColumnIndexOrThrow("numero");
            String numero = c.getString(index);


            lista.add(nome + "/" + numero);
        }
    }

}