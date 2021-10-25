package com.daily_cases_reports.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DecimalFormat;
import java.util.Objects;

public class DetailCustomUsaLayout extends AppCompatActivity {

//    private AdView mAdView;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_custom_usa_layout);


        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }


//        //Ad Mob code
//        AdView adView = new AdView(this);
//        adView.setAdSize(AdSize.BANNER);
//        adView.setAdUnitId("ca-app-pub-9365499454983010/8516642823");
//
//
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);


        pieChart = findViewById(R.id.piechartUnitesStates);

        DecimalFormat formatter = new DecimalFormat("#,###");

        String countryName = getIntent().getStringExtra("stateName");
        long totalCases = getIntent().getLongExtra("totalCases",0);
        long totalDeaths = getIntent().getLongExtra("totalDeaths", 0);
        long totalRecovered = getIntent().getLongExtra("totalRecovered",0);
        long activeCases = getIntent().getLongExtra("activeCases",0);


        TextView countryTextView = findViewById(R.id.state_name_us);
        countryTextView.setText(countryName);

        TextView casesDetailTextView = findViewById(R.id.cases_detail_us);
        casesDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalCases))));

        TextView deathsDetailTextView = findViewById(R.id.deaths_detail_us);
        deathsDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalDeaths))));

        TextView recoveredDetailTextView = findViewById(R.id.recovered_detail_us);
        recoveredDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered))));

        TextView dischargedTextView = findViewById(R.id.discharged_us);
        dischargedTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered))));

        TextView deathsTextView = findViewById(R.id.deaths_us);
        deathsTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalDeaths))));

        TextView casesOutcomeTextView = findViewById(R.id.cases_outcome_us);
        casesOutcomeTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered + totalDeaths))));


        pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(String.valueOf(totalCases)), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(String.valueOf(totalRecovered)), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(String.valueOf(totalDeaths)), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(String.valueOf(activeCases)), Color.parseColor("#29B6F6")));
        pieChart.startAnimation();

    }
}