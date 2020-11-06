package com.example.gitfollowersn2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversorFollowers {

    public List<FollowersGit> getInformacao(String end){
        String json = ConexaoApi.getJsonFromApi(end);
        List<FollowersGit> retorno = parseJson(json);
        return retorno;
    }

    private List<FollowersGit> parseJson(String json){
        try {
            List<FollowersGit> ListaPessoas = new ArrayList<>();
            JSONArray jsonObj = new JSONArray(json);

            for (int i=0; i < jsonObj.length(); i++){
                FollowersGit pessoa = new FollowersGit();
                JSONObject objArray = jsonObj.getJSONObject(i);

                pessoa.setNome(objArray.getString("login"));
                pessoa.setId(objArray.getString("id"));
                ListaPessoas.add(pessoa);
            }

            return ListaPessoas;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}