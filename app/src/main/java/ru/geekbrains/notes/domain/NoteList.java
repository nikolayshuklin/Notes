package ru.geekbrains.notes.domain;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ru.geekbrains.notes.R;


public class NoteList extends Fragment {
    private NoteRepository noteRepository;
    public NoteList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteRepository = new NoteRepositoryImpl();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout noteList = view.findViewById(R.id.note_list_container);
        List<Note> list = noteRepository.getNotes();
        for(Note n: list){
            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, noteList, false);
            TextView name = view.findViewById(R.id.date);
            name.setText(n.getName());
            TextView description = view.findViewById(R.id.description);
            description.setText(n.getDescription());
            TextView date = view.findViewById(R.id.date);
            date.setText(n.getDate());
            noteList.addView(itemView);
        }


        //initListView(view);
    }

    private void initListView(View view){
        LinearLayout linearLayout = (LinearLayout)view;
        NoteRepository noteRepository = new NoteRepositoryImpl();
        List<Note> list = noteRepository.getNotes();
        TextView name = view.findViewById(R.id.date);
        name.setText(list.get(0).getName());
        TextView description = view.findViewById(R.id.description);
        description.setText(list.get(0).getDescription());
        TextView date = view.findViewById(R.id.date);
        date.setText(list.get(0).getDate());
        linearLayout.addView(name);
        linearLayout.addView(description);
        linearLayout.addView(date);



    }
}