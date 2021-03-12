package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.font.TextAttribute;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private IntentIntegrator qrScan;
    private Button buttonScan, next ,video;
    private EditText texto;
    public String id=null, idmaquina;
    public int num=0;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    public String id_maquina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        buttonScan = findViewById(R.id.Scann);
        next=findViewById(R.id.id_maquina);
        video=findViewById(R.id.videochamada);
        texto=findViewById(R.id.ID);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.5:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id_maquina=texto.getText().toString();

                Call<PostList> call = jsonPlaceHolderApi.getPosts(id_maquina);
                call.enqueue(new Callback<PostList>() {
                    @Override
                    public void onResponse(Call<PostList> call, Response<PostList> response) {
                        List<Post> posts = response.body().getList();

                        for (Post post : posts) {
                            idmaquina="";
                            idmaquina=post.getIdmaquina();
                            if(idmaquina.equals(id_maquina)){
                                openButt();
                            }
                        }

                    }
                    @Override
                    public void onFailure(Call<PostList> call, Throwable t) {

                    }
                });
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openconferencia();
            }
        });
        qrScan = new IntentIntegrator(this);
        buttonScan.setOnClickListener(this);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {

            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {

                num=1;
                try {
                    JSONObject obj = new JSONObject(result.getContents());
                    id=obj.getString("id");

                    openButtScan();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    public void onClick(View view) {

        qrScan.initiateScan();

    }
    public void openButt(){

        Intent intent=new Intent(this, qrcode.class);
        intent.putExtra("idmaquina",id_maquina);
        startActivity(intent);

    }
    public void openButtScan(){

        Intent intent=new Intent(this, qrcode.class);
        intent.putExtra("idmaquina",id);
        startActivity(intent);

    }
    public void openconferencia(){

        Intent intent =new Intent(this, conferencia.class);
        startActivity(intent);
    }

}