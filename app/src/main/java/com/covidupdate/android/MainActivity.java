package com.covidupdate.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.covidupdate.android.Services.AboutUs;
import com.covidupdate.android.Services.Disclaimer;
import com.covidupdate.android.Services.Helpline;
import com.covidupdate.android.Services.MaskTips;
import com.covidupdate.android.Services.Precautions;
import com.covidupdate.android.Services.Suggestions;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout helpLineView;
    private RelativeLayout masktipsView;
    private RelativeLayout precautionsView;
    private RelativeLayout suggestionView;
    private RelativeLayout rateusView;
    private RelativeLayout disclaimerView;
    private RelativeLayout aboutusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }

        helpLineView = (RelativeLayout) findViewById(R.id.helpline_view);
        masktipsView = (RelativeLayout) findViewById(R.id.masktips_view);
        precautionsView = (RelativeLayout) findViewById(R.id.precautionary__view);
        suggestionView = (RelativeLayout) findViewById(R.id.suggestion_view);
        rateusView = (RelativeLayout) findViewById(R.id.rate_us_view);
        disclaimerView = (RelativeLayout) findViewById(R.id.disclaimer_view);
        aboutusView = (RelativeLayout) findViewById(R.id.about_us_view);

        setOnClickListenerForButton();
    }


    private void setOnClickListenerForButton() {

        helpLineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpline = new Intent(MainActivity.this, Helpline.class);
                startActivity(helpline);
            }
        });

        masktipsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masktips = new Intent(MainActivity.this, MaskTips.class);
                startActivity(masktips);
            }
        });

        precautionsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent precautions = new Intent(MainActivity.this, Precautions.class);
                startActivity(precautions);
            }
        });

        suggestionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent suggestion = new Intent(MainActivity.this, Suggestions.class);
                startActivity(suggestion);
            }
        });

        rateusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent rateus = new Intent(MainActivity.this, Suggestions.class);
//                startActivity(rateus); PLAY STORE LINK------------------

                Toast.makeText(MainActivity.this, "----------****--", Toast.LENGTH_SHORT).show();

            }
        });

        disclaimerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disclaimer = new Intent(MainActivity.this, Disclaimer.class);
                startActivity(disclaimer);
            }
        });

        aboutusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutus = new Intent(MainActivity.this, AboutUs.class);
                startActivity(aboutus);
            }
        });

    }
}