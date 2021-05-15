package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fechar extends AppCompatActivity {
   private EditText avaria,idma,dataA,dataF,prob,soli,plan;
   private Button Enviar;
   public String avaria1,idma1,dataA1,dataF1,prob1,soli1,plan1;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fechar);
        getSupportActionBar().hide();
        Enviar=findViewById(R.id.Enviar);
        avaria=findViewById(R.id.avaria1);
        idma=findViewById(R.id.idmaquina1);
        dataA=findViewById(R.id.dataabertura1);
        dataF=findViewById(R.id.datafecho1);
        prob=findViewById(R.id.problema1);
        soli=findViewById(R.id.solicitante1);
        plan=findViewById(R.id.planificador1);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.5:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avaria1=avaria.getText().toString();
                idma1=idma.getText().toString();
                dataA1=dataA.getText().toString();
                dataF1=dataF.getText().toString();
                prob1=prob.getText().toString();
                soli1=soli.getText().toString();
                plan1=plan.getText().toString();

                createPost();
            }
        });
    }

    private void createPost(){
        Call<Post> call = jsonPlaceHolderApi.createPost(this.avaria1,this.idma1,this.dataA1,this.dataF1,this.prob1,this.soli1,this.plan1);

    }
}