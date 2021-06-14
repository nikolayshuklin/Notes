package ru.geekbrains.notes.domain;

import androidx.annotation.StringRes;

import java.util.Date;

public class Note {
    @StringRes
    private final int name;
    @StringRes
    private final int description;
    @StringRes
    private final int date;

    public Note(int name, int description, int date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getDate() {
        return date;
    }
}
