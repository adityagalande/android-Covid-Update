package com.daily_cases_report.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DecimalFormat;
import java.util.Objects;

public class DetailCustomIndiaLayout extends AppCompatActivity {

    private AdView mAdView;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_custom_india_layout);

        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }


        //Ad Mob code
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9365499454983010/8516642823");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        pieChart = findViewById(R.id.piechartIndia);



        DecimalFormat formatter = new DecimalFormat("#,###");

        String countryName = getIntent().getStringExtra("provinceName");
        long totalCases = getIntent().getLongExtra("confirmedCases",0);
        long totalDeaths = getIntent().getLongExtra("totalDeaths", 0);
        long totalRecovered = getIntent().getLongExtra("totalRecovered",0);
        long activeCases = getIntent().getLongExtra("activeCases",0);


        TextView countryTextView = findViewById(R.id.ind_state_name);
        countryTextView.setText(countryName);

        TextView casesDetailTextView = findViewById(R.id.cases_detail_ind);
        casesDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalCases))));

        TextView deathsDetailTextView = findViewById(R.id.deaths_detail_ind);
        deathsDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalDeaths))));

        TextView recoveredDetailTextView = findViewById(R.id.recovered_detail_ind);
        recoveredDetailTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered))));

        TextView dischargedTextView = findViewById(R.id.discharged_ind);
        dischargedTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered))));

        TextView deathsTextView = findViewById(R.id.deaths_ind);
        deathsTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalDeaths))));

        TextView casesOutcomeTextView = findViewById(R.id.cases_outcome_ind);
        casesOutcomeTextView.setText(formatter.format(Double.parseDouble(String.valueOf(totalRecovered + totalDeaths))));


        pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(String.valueOf(totalCases)), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(String.valueOf(totalRecovered)), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(String.valueOf(totalDeaths)), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(String.valueOf(activeCases)), Color.parseColor("#29B6F6")));
        pieChart.startAnimation();


    }
}