package ru.geekbrains.notes.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.zip.Inflater;

import ru.geekbrains.notes.R;
import ru.geekbrains.notes.domain.Note;
import ru.geekbrains.notes.domain.NoteRepository;
import ru.geekbrains.notes.domain.NoteRepositoryImpl;

public class NoteListFragment extends Fragment {

    private NoteRepository noteRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteRepository = new NoteRepositoryImpl();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout noteList = view.findViewById(R.id.note_list_container);
        List<Note> notes = noteRepository.getNotes();
        for (Note note: notes){
            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, noteList, false);
            TextView name = itemView.findViewById(R.id.note_name);
            TextView description = itemView.findViewById(R.id.description);
            TextView date = itemView.findViewById(R.id.date);
            name.setText(note.getName());
            description.setText(note.getDescription());
            date.setText(note.getDate());
            noteList.addView(itemView);

        }

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
