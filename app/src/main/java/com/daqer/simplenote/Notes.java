package com.daqer.simplenote;

public class Notes {
    private int _id;
    private String _title;
    private String _description;


    public Notes(String title, String description) {
        this._title = title;
        this._description = description;
    }

    //Constructor for Notes class
    public Notes() {
    }

    //Setter
    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    //Getter

    public int get_id() {
        return _id;
    }

    public String get_title() {
        return _title;
    }

    public String get_description() {
        return _description;
    }
}
