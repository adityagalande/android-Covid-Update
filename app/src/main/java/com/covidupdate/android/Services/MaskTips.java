package com.covidupdate.android.Services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.covidupdate.android.R;

import java.util.ArrayList;
import java.util.Objects;

public class MaskTips extends AppCompatActivity {

    private  String stayHomeSteps;
    private String handWash;
    private TextView stayHomeStepstextView;
    private TextView handWashtextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask_tips);

        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }

        stayHomeSteps = "1. Stay Home\n\n2. KEEP a safe distance\n\n3. WASH hands often\n\n4. COVER your cough\n\n5. SICK? call the helpline\n\n\n\nHow to Protect Yourself and Other from the spread" ;
        handWash = "Wash your hands often with soap and water\n" +
                "for at least 20 seconds, especially after being\n" +
                "in a public place, or after blowing your nose ,\n" +
                "coughing or sneezing\n\n" +
                "If soap and water are not readily available,\n" +
                "use a hand sanitizer with at least 60%\n" +
                "alcohol.Avoid touching your eyes, nose and\n" +
                "mouth with unwashed hands.";

        stayHomeStepstextView = (TextView) findViewById(R.id.stayHomeSteps);
        stayHomeStepstextView.setText(stayHomeSteps);

        handWashtextView = (TextView) findViewById(R.id.Handwash);
        handWashtextView.setText(handWash);

    }
}