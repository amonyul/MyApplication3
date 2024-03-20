package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    EditText editText_title, editText_notes;
    ImageView imageView_save;
    Notes notes;
    boolean isOldNote = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        imageView_save = findViewById(R.id.imageView_save);
        editText_title = findViewById(R.id.editText_title);

        editText_notes = findViewById(R.id.editText_notes);

        notes = new Notes();
        try {
            notes = (Notes) getIntent().getSerializableExtra("get_note");
            editText_title.setText(notes.getTitle());
            editText_notes.setText(notes.getNotes());
            isOldNote = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String title = editText_title.getText().toString();
                  String descriprion = editText_notes.getText().toString();

                  if (descriprion.isEmpty()){
                      Toast.makeText(NotesTakerActivity.this,"Please, enter description",Toast.LENGTH_SHORT).show();
                      return;
                  }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
                  Date date = new Date();

                  if (!isOldNote){
                      notes = new Notes();
                  }
                  notes.setTitle(title);
                  notes.setNotes(descriprion);
                  notes.setDate(formatter.format(date));

                  Intent intent = new Intent();
                  intent.putExtra("note", notes);
                  setResult(Activity.RESULT_OK,intent);

                  finish();
            }
        });

    }
}