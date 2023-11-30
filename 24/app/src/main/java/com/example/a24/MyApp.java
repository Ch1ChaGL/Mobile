package com.example.a24;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    private final List<Note> notes = new ArrayList<Note>();
    public static final int CREATE_ACTION = 1;
    public static final int EDIT_ACTION = 2;
    private int noteId = -1;
    public static int CurrentActionCode = -1;
    public MyApp(){
        super();
        notes.add(new Note("Title-1", "Record-1", Note.getCurrentTime()));
        notes.add(new Note("Title-2", "Record-2", Note.getCurrentTime()));
    }
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }
    public void add(Note note){
        notes.add(note);
    }
    public Note getNoteById(int id){
        return notes.get(id);
    }

    public void set(int id, Note note){
        notes.set(id, note);
    }

    public int size(){
        return notes.size();
    }

    public List<Note> getNotes() {
        return notes;
    }
}
