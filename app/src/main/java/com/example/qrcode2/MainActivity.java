package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private IntentIntegrator qrScan;
    private Button buttonScan;
    public String id=null;
    public int num=0;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonScan = findViewById(R.id.Scann);
        texto=findViewById(R.id.texto);

        qrScan = new IntentIntegrator(this);
        buttonScan.setOnClickListener(this);
        openButtScan();


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                num=1;
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    texto.setText(obj.getString("id"));
                    id=obj.getString("id");
                    openButtScan();
                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
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

        Intent intent=new Intent(this, Menu.class);
       
        startActivity(intent);

    }
}