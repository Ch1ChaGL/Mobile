package com.example.a24;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a24.API.NoteAPI;
import com.example.a24.Models.Note;
import com.example.a24.ViewModel.NoteViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;

    private NoteViewModel noteViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);


        noteViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(NoteViewModel.class);

        // Подписываемся на изменения LiveData
        noteViewModel.getNotesLiveData().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                // Обработка полученного списка заметок
                for (Note note : notes) {
                    Log.d("NoteApp", "Note Title: " + note.getNoteTitle());
                }
            }
        });

        lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void clickAdd(View view){
        int noteId = 1; // Замените на реальный ID
        noteViewModel.loadNoteById(noteId);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }
}
