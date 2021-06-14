package ru.geekbrains.notes.domain;

import java.util.List;

public interface NoteRepository {
    public List<Note> getNotes();
}
