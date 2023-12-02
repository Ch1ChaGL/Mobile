package com.example.a24.ViewModel;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a24.API.NoteAPI;
import com.example.a24.Models.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoteViewModel extends ViewModel {
    private final MutableLiveData<List<Note>> notesLiveData = new MutableLiveData<>();

    public LiveData<List<Note>> getNotesLiveData() {
        return notesLiveData;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void loadNotes() {
        NoteAPI.getAllNotes(new Callback<List<Note>>() {
            @Override
            public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                if (response.isSuccessful()) {
                    List<Note> notes = response.body();
                    notesLiveData.postValue(notes);
                } else {
                    Log.e("ApiCall", "Failed to get notes");
                }
            }

            @Override
            public void onFailure(Call<List<Note>> call, Throwable t) {
                Log.e("ApiCall", "Failed to make API call", t);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void loadNoteById(int noteId) {
        NoteAPI.getNoteById(noteId, new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                if (response.isSuccessful()) {
                    Note note = response.body();
                    Log.d("NoteApp", "Note Title: " + note.getNoteTitle());
                    // Обработка полученной заметки
                    // Например, обновление интерфейса или другие действия
                } else {
                    Log.e("ApiCall", "Failed to get note by ID");
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                Log.e("ApiCall", "Failed to make API call", t);
            }
        });
    }

}
