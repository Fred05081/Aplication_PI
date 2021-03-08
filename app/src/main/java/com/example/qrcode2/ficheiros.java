package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ficheiros extends AppCompatActivity {
    private Button button1,button2,button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficheiros);

        button1=findViewById(R.id.infoMaquina);
        button2=findViewById(R.id.foto);
        button3=findViewById(R.id.videos);
        button4=findViewById(R.id.pdf);

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

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open4();
            }
        });


    }

    public void open1(){
        Intent intent=new Intent(this,info.class);

        startActivity(intent);

    }
    public void open2(){
        Intent intent=new Intent(this,foto.class);

        startActivity(intent);

    }
    public void open3(){
        Intent intent=new Intent(this,video.class);

        startActivity(intent);

    }
    public void open4(){
        Intent intent=new Intent(this,pdf.class);

        startActivity(intent);

    }

}