package com.example.gitfollowersn2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ActivityFollower extends AppCompatActivity {
    private TextView nome;
    private TextView id;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);

        ActivityFollower.DownloadPessoa download = new ActivityFollower.DownloadPessoa();

        nome = (TextView) findViewById(R.id.textView12);
        id = (TextView) findViewById(R.id.textView14);

        //Chama Async Task
        download.execute();

    }
    private class DownloadPessoa extends AsyncTask<Void, Void, List<FollowersGit>> {

        @Override
        protected void onPreExecute(){
            //inicia o dialog
            load = ProgressDialog.show(ActivityFollower.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected List<FollowersGit> doInBackground(Void... params) {
            ConversorFollowers util = new ConversorFollowers();
            return util.getInformacao("https://api.github.com/users/giselezrossi/followers");
        }

        @Override
        protected void onPostExecute(List<FollowersGit> ListaPessoa){
            String auxNome = null;
            String auxId = null;
            for(FollowersGit pessoa:ListaPessoa){
                auxNome = auxNome + pessoa.getNome() + " | ";
                auxId = auxId + pessoa.getId() + " | ";
            }
            nome.setText(auxNome);
            id.setText(auxId);

            load.dismiss(); //deleta o dialog
        }
    }
}