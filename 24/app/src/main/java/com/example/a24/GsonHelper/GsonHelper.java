package com.example.a24.GsonHelper;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.OffsetDateTime;

public class GsonHelper {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Gson buildGson() {
        return new GsonBuilder()
                .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeAdapter())
                .create();
    }
}
