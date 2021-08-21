package com.daily_cases_report.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.squareup.picasso.Picasso;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DecimalFormat;
import java.util.Objects;

public class DetailCustomLayout extends AppCompatActivity {

//    private AdView mAdView;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_custom_layout);

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


        pieChart = findViewById(R.id.piechartWorldWide);

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


        pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(String.valueOf(totalCases)), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(String.valueOf(totalRecovered)), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(String.valueOf(totalDeaths)), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(String.valueOf(activeCases)), Color.parseColor("#29B6F6")));
        pieChart.startAnimation();

    }
}