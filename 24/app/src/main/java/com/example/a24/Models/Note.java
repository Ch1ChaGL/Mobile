package com.example.a24.Models;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class Note implements Serializable {
    private int NoteID;
    private String NoteTitle;
    private String NoteData;

    private OffsetDateTime NoteTime;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

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

    public OffsetDateTime getNoteTime() {
        return NoteTime;
    }

    public void setNoteTime(OffsetDateTime noteTime) {
        NoteTime = noteTime;
    }
}
