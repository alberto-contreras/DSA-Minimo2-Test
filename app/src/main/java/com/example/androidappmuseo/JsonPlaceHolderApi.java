package com.example.androidappmuseo;

import com.example.androidappmuseo.models.Museums;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    //All the API request that we are going to do

    @GET("/api/dataset/museus/format/json/pag-ini/1/pag-fi/10")
    Call <Museums> getMuseums(); //We receive the object museum where we have a list of elemets that are museus



}
