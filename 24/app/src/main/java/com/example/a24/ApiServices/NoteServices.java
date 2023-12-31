package com.example.a24.ApiServices;

import com.example.a24.Models.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface NoteServices {
    @GET("api/note")
    Call<List<Note>> getNotes();

    @GET("api/note/{id}")
    Call<Note> getNoteById(@Path("id") int noteId);

    @POST("api/note")
    Call<Note> createNote(@Body Note note);

    @PUT("api/note")
    Call<Note> updateNote(@Body Note note);

    @DELETE("api/note/{id}")
    Call<Void> deleteNote(@Path("id") int noteId);

}
