package com.example.a24.Models;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;

public class Note implements Serializable {
    private int NoteID;
    private String NoteTitle;
    private String NoteData;
    private LocalDateTime NoteTime;

    public int getNoteID() {
        return NoteID;
    }

    public void setNoteID(int noteID) {
        NoteID = noteID;
    }

    public String getNoteTitle() {
        return NoteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        NoteTitle = noteTitle;
    }

    public String getNoteData() {
        return NoteData;
    }

    public void setNoteData(String noteData) {
        NoteData = noteData;
    }

    public LocalDateTime getNoteTime() {
        return NoteTime;
    }

    public void setNoteTime(LocalDateTime noteTime) {
        NoteTime = noteTime;
    }
}
