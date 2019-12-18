package com.example.androidappmuseo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.androidappmuseo.models.Element;
import com.example.androidappmuseo.models.Museums;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Element> listofmuseums;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    private RecyclerView museumsRV;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://do.diba.cat/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);// Show progress bar
        //HOW TO PRESENT THE LIST OF ITEMS
        museumsRV = (RecyclerView) findViewById(R.id.RecyclerMuseums);
        museumsRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //HOW TO PRESENT THE LIST OF ITEMS
        getMuseums();
    }
    private void getMuseums(){

//        Call<Museums> call = jsonPlaceHolderApi.getMuseums("1", "15");

        Call<Museums> call = jsonPlaceHolderApi.getMuseums();
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if (response.isSuccessful()) {
                    Museums museums = response.body();
                    listofmuseums = museums.getElements();

                    for (Element elem: listofmuseums) {
                        Log.d("ALBERTO", elem.getAdrecaNom());
                    }

                    MyMuseumRecyclerViewAdapter adapter1 = new MyMuseumRecyclerViewAdapter(listofmuseums);//Create the adapter and send the list of museum
                    progressBar.setVisibility(View.GONE);//close progress bar
                    museumsRV.setAdapter(adapter1);//Set the adapter
                }

            }

            @Override
            public void onFailure(Call<Museums> call, Throwable t) {

            }
        });





    }
}
