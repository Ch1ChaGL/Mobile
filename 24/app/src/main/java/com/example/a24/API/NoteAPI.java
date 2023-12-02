package com.example.a24.API;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.a24.ApiServices.NoteServices;
import com.example.a24.Models.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.O)
public class NoteAPI {
    private static NoteServices noteServices = ApiClient.getNoteServices();

    public static void getAllNotes(Callback<List<Note>> callback) {
        Call<List<Note>> getNotesCall = noteServices.getNotes();
        getNotesCall.enqueue(callback);
    }

    public static void getNoteById(int noteId, Callback<Note> callback) {
        Call<Note> getNoteCall = noteServices.getNoteById(noteId);
        getNoteCall.enqueue(callback);
    }

    public static void createNote(Note note, Callback<Note> callback) {
        Call<Note> createNoteCall = noteServices.createNote(note);
        createNoteCall.enqueue(callback);
    }
}
