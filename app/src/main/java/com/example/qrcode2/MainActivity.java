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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private IntentIntegrator qrScan;
    private Button buttonScan, next ,video;
    private EditText texto;
    public String id=null;
    public int num=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonScan = findViewById(R.id.Scann);
        next=findViewById(R.id.id_maquina);
        video=findViewById(R.id.videochamada);
        texto=findViewById(R.id.ID);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButtScan();
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
        openButtScan();


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
    public void openButtScan(){

        Intent intent=new Intent(this, qrcode.class);
       
        startActivity(intent);

    }
    public void openconferencia(){

        Intent intent =new Intent(this, conferencia.class);
        startActivity(intent);
    }

}