package com.example.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
public class foto extends AppCompatActivity {
    GridView gridView;
   public String idmaquina;
    private List<ImagesResponse>imagesResponseList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        gridView = findViewById(R.id.gridView);
        getSupportActionBar().hide();
        getAllimages();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(foto.this,click.class).putExtra("data",imagesResponseList.get(i)) );
            }
        });
    }

    public void getAllimages(){
        Call<List<ImagesResponse>> imagesResponse = ApiClient.getinterface().getAllimages();
        imagesResponse.enqueue(new Callback<List<ImagesResponse>>() {
            @Override
            public void onResponse(Call<List<ImagesResponse>> call, Response<List<ImagesResponse>> response) {
                if(response.isSuccessful()){

                    imagesResponseList = response.body();
                    CustomAdapter customAdapter=new CustomAdapter(imagesResponseList,foto.this);
                    gridView.setAdapter(customAdapter);
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<ImagesResponse>> call, Throwable t) {

            }
        });
    }

    public class CustomAdapter extends BaseAdapter{
    private List<ImagesResponse>imagesResponseList;
    private Context context;
    private LayoutInflater layoutInflater;

        public CustomAdapter(List<ImagesResponse> imagesResponseList, Context context) {
            this.imagesResponseList = imagesResponseList;
            this.context = context;
            this.layoutInflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return imagesResponseList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view=layoutInflater.inflate(R.layout.row_grid_items,viewGroup,false);

            }
            ImageView imageView=view.findViewById(R.id.imageView);
            TextView textView= view.findViewById(R.id.textView);
            idmaquina="";
            idmaquina=imagesResponseList.get(i).getIdmaquina();

            if(idmaquina.equals("3311")){
                textView.setText(imagesResponseList.get(i).getIdmaquina());

                Glide.with(context)
                        .load(imagesResponseList.get(i).getImage())
                        .into(imageView);
            }


            return view;
        }
    }

}

