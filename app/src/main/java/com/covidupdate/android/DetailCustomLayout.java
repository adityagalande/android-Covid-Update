package com.covidupdate.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.covidupdate.android.Services.WorldWideCases;
import com.covidupdate.android.Utilities.CasesAdapter;
import com.covidupdate.android.Utilities.CasesData;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.Objects;

public class DetailCustomLayout extends AppCompatActivity {

    CasesData casesData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_custom_layout);

        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }


        DecimalFormat formatter = new DecimalFormat("#,###");

        String countryName = getIntent().getStringExtra("countryName");
        String countryIMG = getIntent().getStringExtra("countryIMG");
        long totalCases = getIntent().getLongExtra("totalCases",0);
        long totalDeaths = getIntent().getLongExtra("totalDeaths", 0);
        long totalRecovered = getIntent().getLongExtra("totalRecovered",0);
        long activeCases = getIntent().getLongExtra("activeCases",0);
        long seriousCases = getIntent().getLongExtra("seriousCases",0);


        TextView countryTextView = findViewById(R.id.country_name);
        countryTextView.setText(countryName);

        ImageView imageView = findViewById(R.id.country_flag);
        Picasso.with(this).load(countryIMG).into(imageView);

        TextView casesDetailTextView = findViewById(R.id.cases_detail);
        casesDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalCases))));

        TextView deathsDetailTextView = findViewById(R.id.deaths_detail);
        deathsDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalDeaths))));

        TextView recoveredDetailTextView = findViewById(R.id.recovered_detail);
        recoveredDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered))));

        TextView currentlyInfectedTextView = findViewById(R.id.currently_infected);
        currentlyInfectedTextView.setText(formatter.format(Double.parseDouble(String.valueOf(activeCases))));

        TextView seriousCriticalTextView = findViewById(R.id.serious_critical);
        seriousCriticalTextView.setText(formatter.format(Double.parseDouble(String.valueOf(seriousCases))));

        TextView mildConditionTextView = findViewById(R.id.mild_condition);
        mildConditionTextView.setText(formatter.format(Double.parseDouble(String.valueOf(activeCases - seriousCases))));

        TextView dischargedTextView = findViewById(R.id.discharged);
        dischargedTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered))));

        TextView deathsTextView = findViewById(R.id.deaths);
        deathsTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalDeaths))));

        TextView casesOutcomeTextView = findViewById(R.id.cases_outcome);
        casesOutcomeTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered + totalDeaths))));

    }
}