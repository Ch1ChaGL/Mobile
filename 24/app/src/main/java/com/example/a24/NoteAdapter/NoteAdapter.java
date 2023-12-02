package com.example.a24.NoteAdapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.a24.Models.Note;
import com.example.a24.R;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class NoteAdapter extends BaseAdapter {

    private List<Note> notes;
    private Context context;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");

    public NoteAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_note, parent, false);
        }

        // Получаем текущую заметку
        Note note = (Note) getItem(position);

        // Настраиваем элементы пользовательского интерфейса
        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView dataTextView = convertView.findViewById(R.id.dataTextView);
        TextView dateTimeTextView = convertView.findViewById(R.id.DateTimeTextView);
        TextView priorityTextView = convertView.findViewById(R.id.priorityTextView);

        titleTextView.setText(note.getNoteTitle());
        dataTextView.setText(note.getNoteData());
        priorityTextView.setText(note.getNotePriority());

        dateTimeTextView.setText(note.getNoteTime().format(formatter));

        return convertView;
    }

}
