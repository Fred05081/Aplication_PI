package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ordem_trabalho extends AppCompatActivity {
    private TextView avaria,problema,data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem_trabalho);
        avaria=findViewById(R.id.avaria);
        problema=findViewById(R.id.descricao);
        data=findViewById(R.id.data);


    }
}