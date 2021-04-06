package com.covidupdate.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.covidupdate.android.R;

import java.util.Objects;

public class Suggestions extends AppCompatActivity {

    private Toast mToast;
    EditText name, emailSubject, emailMessage;
    RelativeLayout sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.suggestions_action_bar);

        TextView title2TextView = findViewById(R.id.suggestionFormTitle2);
        String title2String = "Do you have suggestion or found some bug?\n" +
                "let us know in the field below.";
        title2TextView.setText(title2String);


        name = findViewById(R.id.name);
        emailSubject = findViewById(R.id.emailSubject);
        emailMessage = findViewById(R.id.emailMessage);
        sendButton = findViewById(R.id.sendSuggestionButon);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipient = "adityagalande14@gmail.com".trim();
                String subject = emailSubject.getText().toString().trim();
                String message = emailMessage.getText().toString().trim();

                sendEmail(recipient, subject, message);
            }
        });

    }


    @SuppressLint("IntentReset")
    private void sendEmail(String recipient, String subject, String message) {

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.setPackage("com.google.android.gm");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Name : " + name.getText().toString().trim() + "\nSubject : " + subject + "\nMessage : " + message);


        try {
            if (subject.isEmpty() || message.isEmpty()) {

                if (mToast != null) {
                    mToast.cancel();
                }

                mToast = Toast.makeText(this, "Please fill all field", Toast.LENGTH_LONG);
                mToast.show();

            } else {
                startActivity(emailIntent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}