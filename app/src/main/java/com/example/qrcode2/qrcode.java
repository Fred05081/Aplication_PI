package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class qrcode extends AppCompatActivity {
    private Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        button1=findViewById(R.id.ot);
        button2=findViewById(R.id.ficheiros);
        button3=findViewById(R.id.historico);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3();
            }
        });

//mexer
    }

    public void open1(){
        Intent intent=new Intent(this,lista_ota.class);

        startActivity(intent);

    }
    public void open2(){
        Intent intent=new Intent(this,ficheiros.class);

        startActivity(intent);

    }
    public void open3(){
        Intent intent=new Intent(this,historico.class);

        startActivity(intent);

    }
}