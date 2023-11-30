package com.example.a24.ApiServices;

import com.example.a24.Models.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NoteServices {
    @GET("api/note")
    Call<List<Note>> getNotes();

}
