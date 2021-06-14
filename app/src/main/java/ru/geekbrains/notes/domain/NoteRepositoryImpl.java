package ru.geekbrains.notes.domain;

import java.util.ArrayList;
import java.util.List;

import ru.geekbrains.notes.R;

public class NoteRepositoryImpl implements NoteRepository {
    public List<Note> getNotes(){
        ArrayList<Note> result = new ArrayList<>();
        result.add(new Note(R.string.note1, R.string.description1, R.string.date1));
        result.add(new Note(R.string.note2, R.string.description2, R.string.date2));
        result.add(new Note(R.string.note3, R.string.description3, R.string.date3));
        return result;
    }
}
