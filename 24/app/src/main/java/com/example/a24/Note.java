package com.example.a24;

import java.io.Serializable;
import java.sql.Time;

public class Note implements Serializable {
    private String _title;
    private String _note;
    private Time _editTime;

    public Note( String title, String note, Time editTime ){
        _title = title;
        _note = note;
        _editTime = editTime;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public Time get_editTime() {
        return _editTime;
    }

    public void set_editTime(Time _editTime) {
        this._editTime = _editTime;
    }

    static public Time getCurrentTime(){
        return new Time(System.currentTimeMillis());
    }
}
