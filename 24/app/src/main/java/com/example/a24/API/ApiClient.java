package com.example.a24.API;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.a24.ApiServices.NoteServices;
import com.example.a24.GsonHelper.GsonHelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ApiClient {
    private static final String BASE_URL = "http://10.0.2.2:5001/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonHelper.buildGson()))
            .build();

    public static NoteServices getNoteServices() {
        return retrofit.create(NoteServices.class);
    }
}
