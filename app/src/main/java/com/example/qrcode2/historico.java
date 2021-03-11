package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class historico extends AppCompatActivity {
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        getSupportActionBar().hide();

        texto=findViewById(R.id.hist);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.5:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //
        //Map<String,String> parameters = new HashMap<>();
        //parameters.put("idmaquina","3456");
        //
        Call<PostList> call = jsonPlaceHolderApi.getPosts("3145");
        call.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                List<Post> posts = response.body().getList();

                for (Post post : posts) {

                    // fazer print de tudo ----> esperar
                    String content ="\n";
                    content += "avaria : " + post.getAvaria() + "\n";
                    content += "idmaquina : " + post.getIdmaquina() + "\n";
                    content += "dataAbertura : " + post.getDataabertura() + "\n";
                    content += "datafecho : " + post.getDatafecho() + "\n";
                    content += "problema : " + post.getProblema() + "\n";
                    content += "solicitante : " + post.getSolicitante() + "\n";
                    content += "planificador : " + post.getPlanificador() + "\n";
                    texto.append(content);


                    //processo de filtragem pelo tipo de avaria, e pelo numero da maquina  no caso 3145
                    /*if(post.getAvaria().equals("mecanico")){
                        String content ="\n";
                        content += "avaria : " + post.getAvaria() + "\n";
                        content += "idmaquina : " + post.getIdmaquina() + "\n";
                        content += "dataAbertura : " + post.getDataabertura() + "\n";
                        content += "datafecho : " + post.getDatafecho() + "\n";
                        content += "problema : " + post.getProblema() + "\n";
                        content += "solicitante : " + post.getSolicitante() + "\n";
                        content += "planificador : " + post.getPlanificador() + "\n";
                        texto.append(content);

                    }
                    if(post.getAvaria().equals("eletrico")){
                        String content ="\n";
                        content += "avaria : " + post.getAvaria() + "\n";
                        content += "idmaquina : " + post.getIdmaquina() + "\n";
                        content += "dataAbertura : " + post.getDataabertura() + "\n";
                        content += "datafecho : " + post.getDatafecho() + "\n";
                        content += "problema : " + post.getProblema() + "\n";
                        content += "solicitante : " + post.getSolicitante() + "\n";
                        content += "planificador : " + post.getPlanificador() + "\n";
                        texto.append(content);

                    }
                    if(post.getAvaria().equals("software")){
                        String content ="\n";
                        content += "avaria : " + post.getAvaria() + "\n";
                        content += "idmaquina : " + post.getIdmaquina() + "\n";
                        content += "dataAbertura : " + post.getDataabertura() + "\n";
                        content += "datafecho : " + post.getDatafecho() + "\n";
                        content += "problema : " + post.getProblema() + "\n";
                        content += "solicitante : " + post.getSolicitante() + "\n";
                        content += "planificador : " + post.getPlanificador() + "\n";
                        texto.append(content);

                    }
                    */


                }

            }
            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                texto.setText(t.getMessage());
            }
        });
    }
}