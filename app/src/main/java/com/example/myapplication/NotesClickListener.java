package com.example.myapplication;

import androidx.cardview.widget.CardView;

import com.example.myapplication.Models.Notes;

public interface NotesClickListener {

    void onClick (Notes notes);
    void onLongClick (Notes notes, CardView cardView);



}
