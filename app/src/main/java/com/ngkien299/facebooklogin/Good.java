package com.ngkien299.facebooklogin;

import java.io.Serializable;

public class Good implements Serializable {
    private int _id;
    private String _name;
    private int _total;

    public Good(int _id, String _name, int _total) {
        this._id = _id;
        this._name = _name;
        this._total = _total;
    }

    @Override
    public String toString() {
        return _name + " - " + _total;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_total() {
        return _total;
    }

    public void set_total(int _total) {
        this._total = _total;
    }
}
