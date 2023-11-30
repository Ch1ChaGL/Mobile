package com.example.a24.API;

import android.util.Log;

import com.example.a24.ApiServices.NoteServices;
import com.example.a24.Models.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoteAPI {
    private static NoteServices noteServices = ApiClient.getNoteServices();

    public static List<Note> getAllNotes(){
        Call<List<Note>> getNotesCall = noteServices.getNotes();
        getNotesCall.enqueue(new Callback<List<Note>>() {
            @Override
            public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                if (response.isSuccessful()) {
                    List<Note> notes = response.body();

                } else {
                    Log.e("ApiCall", "ЕБАЛ");
                }
            }

            @Override
            public void onFailure(Call<List<Note>> call, Throwable t) {
                Log.e("ApiCall", "Failed to make API call", t);
            }
        });
        return null;
    }
}
