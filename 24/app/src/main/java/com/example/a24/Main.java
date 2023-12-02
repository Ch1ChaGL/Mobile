package com.example.a24;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a24.API.NoteAPI;
import com.example.a24.Models.Note;
import com.example.a24.NoteAdapter.NoteAdapter;
import com.example.a24.ViewModel.NoteViewModel;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;

    private NoteViewModel noteViewModel;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);


        noteViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(NoteViewModel.class);

        lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(this);

        // Подписываемся на изменения LiveData
        noteViewModel.getNotesLiveData().observe(this, new Observer<List<Note>>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onChanged(List<Note> notes) {
                // Создаем адаптер и связываем его с данными
                NoteAdapter noteAdapter = new NoteAdapter(Main.this, notes);

                // Устанавливаем адаптер для ListView
                lv.setAdapter(noteAdapter);
            }
        });
        noteViewModel.loadNotes();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void clickAdd(View view){
        // Создание объекта AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(dialogView);

        // Получение элементов управления из макета
        EditText editText = dialogView.findViewById(R.id.text);
        EditText title = dialogView.findViewById(R.id.title);
        Spinner spinnerPriority = dialogView.findViewById(R.id.spinnerPriority);
        DatePicker datePicker = dialogView.findViewById(R.id.datePicker);
        TimePicker timePicker = dialogView.findViewById(R.id.timePicker);

        // Настройка Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.priority_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(adapter);

        // Настройка DatePicker и TimePicker
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), null);

        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
        timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));

        // Настройка кнопок в диалоге
        builder.setPositiveButton("OK", (dialog, which) -> {
            // Получение данных из элементов управления
            String text = editText.getText().toString();
            String priority = spinnerPriority.getSelectedItem().toString();
            String titleString = title.getText().toString();

            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int day = datePicker.getDayOfMonth();

            int hour;
            int minute;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                hour = timePicker.getHour();
                minute = timePicker.getMinute();
            } else {
                hour = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();
            }

            // Создание объекта Calendar с выбранной датой и временем
            Calendar selectedCalendar = Calendar.getInstance();
            Instant instant = selectedCalendar.toInstant();
            selectedCalendar.set(year, month, day, hour, minute);

            // Создание объекта OffsetDateTime
            OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneId.systemDefault());

            Note newNote = new Note();

            newNote.setNoteTitle(titleString);
            newNote.setNoteData(text);
            newNote.setNotePriority(priority);
            newNote.setNoteTime(offsetDateTime);


            noteViewModel.createNote(newNote);

            //noteViewModel.loadNotes();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // Закрытие диалога при отмене
            dialog.cancel();
        });

        // Отображение диалога
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // Get adapter from AdapterView
        NoteAdapter noteAdapter = (NoteAdapter) adapterView.getAdapter();

        // get element Note from i
        Note clickedNote = (Note) noteAdapter.getItem(i);

        // Создание объекта AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(dialogView);

        // Получение элементов управления из макета
        EditText editText = dialogView.findViewById(R.id.text);
        EditText title = dialogView.findViewById(R.id.title);
        Spinner spinnerPriority = dialogView.findViewById(R.id.spinnerPriority);
        DatePicker datePicker = dialogView.findViewById(R.id.datePicker);
        TimePicker timePicker = dialogView.findViewById(R.id.timePicker);

        // Настройка Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.priority_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(adapter);

        //Fill alertDialog
        editText.setText(clickedNote.getNoteData());
        title.setText(clickedNote.getNoteTitle());

        // Получаем строковое значение приоритета
        String selectedPriority = clickedNote.getNotePriority();

        // Ищем соответствующую позицию в массиве данных
        int selectedPosition = -1;
        for (int index = 0; i < adapter.getCount(); index++) {
            if (adapter.getItem(index).toString().equals(selectedPriority)) {
                selectedPosition = index;
                break;
            }
        }

        // Если нашли соответствие, устанавливаем выбранную позицию
        if (selectedPosition != -1) {
            spinnerPriority.setSelection(selectedPosition);
        }

        //todo сделать отображение даты из бд

        // Настройка DatePicker и TimePicker
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), null);

        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
        timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));

        // Настройка кнопок в диалоге
        builder.setPositiveButton("OK", (dialog, which) -> {
            // Получение данных из элементов управления
            String text = editText.getText().toString();
            String priority = spinnerPriority.getSelectedItem().toString();
            String titleString = title.getText().toString();

            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int day = datePicker.getDayOfMonth();

            int hour;
            int minute;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                hour = timePicker.getHour();
                minute = timePicker.getMinute();
            } else {
                hour = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();
            }

            // Создание объекта Calendar с выбранной датой и временем
            Calendar selectedCalendar = Calendar.getInstance();
            Instant instant = selectedCalendar.toInstant();
            selectedCalendar.set(year, month, day, hour, minute);

            // Создание объекта OffsetDateTime
            OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneId.systemDefault());

            Note newNote = new Note();

            newNote.setNoteTitle(titleString);
            newNote.setNoteData(text);
            newNote.setNotePriority(priority);
            newNote.setNoteTime(offsetDateTime);


            noteViewModel.createNote(newNote);

            //noteViewModel.loadNotes();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // Закрытие диалога при отмене
            dialog.cancel();
        });

        // Отображение диалога
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
