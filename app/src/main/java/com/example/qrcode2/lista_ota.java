package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lista_ota extends AppCompatActivity {
    private Button criar_ot,ultimasman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ota);

        criar_ot=findViewById(R.id.criar_ot);
        ultimasman=findViewById(R.id.ultimas_man);
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
}