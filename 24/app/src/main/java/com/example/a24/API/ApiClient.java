package com.example.a24.API;

import com.example.a24.ApiServices.NoteServices;
import com.example.a24.GsonHelper.GsonHelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://10.0.2.2:5001/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static NoteServices getNoteServices() {
        return retrofit.create(NoteServices.class);
    }
}
