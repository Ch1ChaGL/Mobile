package com.example.a19;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    private final List<String> notes = new ArrayList<String>();
    public static final int CREATE_ACTION = 1;
    public static final int EDIT_ACTION = 2;
    private int noteId = -1;
    public static int CurrentActionCode = -1;
    public MyApp(){
        super();
        notes.add("Record 1");
        notes.add("Record 2");
    }
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }
    public void add(String note){
        notes.add(note);
    }
    public String getNoteById(int id){
        return notes.get(id);
    }

    public void set(int id, String note){
        notes.set(id, note);
    }

    public int size(){
        return notes.size();
    }

    public List<String> getNotes() {
        return notes;
    }
}
