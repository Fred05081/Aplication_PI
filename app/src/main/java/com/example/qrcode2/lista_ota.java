package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lista_ota extends AppCompatActivity {
    private Button criar_ot,ultimasman, fechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ota);

        getSupportActionBar().hide();
        fechar=findViewById(R.id.fecharordem);
        criar_ot=findViewById(R.id.criar_ot);
        ultimasman=findViewById(R.id.ultimas_man);
        fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFechar();
            }
        });
        criar_ot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCriar();
            }
        });
        ultimasman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUlt();
            }
        });


    }

    public void openCriar(){
        Intent intent=new Intent(this, criar_ot.class);
        startActivity(intent);

    }

    public void openUlt(){
        Intent intent=new Intent(this, historico.class);
        startActivity(intent);

    }

    public void openFechar(){
        Intent intent=new Intent(this, fechar.class);
        startActivity(intent);

    }
}