package com.covidupdate.android.Services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.covidupdate.android.R;

import java.util.Objects;

public class Suggestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }

        TextView title2TextView = findViewById(R.id.suggestionFormTitle2);
        String title2String = "Do you have suggestion or found some bug?\n" +
                "let us know in the field below.";
        title2TextView.setText(title2String);

    }
}