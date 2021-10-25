package com.daily_cases_reports.android.Services;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.daily_cases_reports.android.AdvisoryAdapterClass.AdvisoryAdapter;
import com.daily_cases_reports.android.R;

import java.util.ArrayList;

public class Advisory extends AppCompatActivity {

//    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisory);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.advisory_action_bar);



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






        final ArrayList<com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory> advisoryContent = new ArrayList<>();
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #1 - Herd immunity", "https://youtu.be/U47SaDAmyrE"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #2 - SARS-CoV-2", "https://youtu.be/Rg6Tf5ZN5rQ"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #3 - COVID-19 Myths Vs Science", "https://youtu.be/Iy1xeIVeRwY"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #4 - Reopening Schools", "https://youtu.be/2Dy7dVm7qVE"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #5 - Vaccine", "https://youtu.be/a8bzJCBUQmc"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #6 - Flu & COVID-19", "https://youtu.be/0taCcDHTURw"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #7 - Serological surveys", "https://youtu.be/tLwncrEbTro"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #8 - Myth vs Science", "https://youtu.be/Rr6ABy2Kf_Y"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #9 - Air pollution & COVID-19", "https://youtu.be/Lbk1i67KQLY"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #10 - Ventilation & COVID-19", "https://youtu.be/XJC1f7F4qtc"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #11", "https://youtu.be/lFpLIDQcdyQ"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #12 - Safe celebrations during the Pandemic", "https://youtu.be/AVMjczPZkGk"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #13 - COVID-19 - Vaccine trials", "https://youtu.be/DejroJH8-uA"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #14 - COVID-19 - Tests", "https://youtu.be/Odltcv6q96I"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #15 - COVID-19 - Vaccine distribution", "https://youtu.be/FFwvwIZQWa4"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #16 - COVID-19 - Vaccine technologies", "https://youtu.be/V4JAo9PhnoI"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #17 - COVID-19 - Vaccine approvals", "https://youtu.be/ofnMToabi50"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #18 - COVID-19 - Immunity after recovery from COVID-19", "https://youtu.be/OIsz3-Mz3eQ"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #19 - COVID-19- Prolonged symptoms after COVID -19 ", "https://youtu.be/KNUnoIbchJI"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #20 - COVID-19 - Variants & Vaccines", "https://youtu.be/gjnPZKMNmqc"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #21 - COVID-19 - Origins of the SARS-CoV-2 virus", "https://youtu.be/SO1N3-s05QA"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #22 - Children & COVID-19", "https://youtu.be/t6OYU8WH9Ww"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #23 - I am vaccinated, what next?", "https://youtu.be/YgfeV9b1K4M"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #24 - Vaccine myths vs science", "https://youtu.be/B-aaVh0BQSw"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #25 - Vaccines explained", "https://youtu.be/ihi55JzTCqU"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #26 - Vaccine dosage", "https://youtu.be/GnwW0baQ1_Q"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #27 - Vaccines, variants & herd immunity", "https://youtu.be/DV2JF2jfpiY"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #28 - Evolution of the SARS-CoV-2 virus", "https://youtu.be/YDSpsvauF8g"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #29 - Developing WHO’s public health advice", "https://youtu.be/azTr3yS7fdQ"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #30 - Vaccines-when and why?", "https://youtu.be/Fy3tcSdH-2o"));
        advisoryContent.add(new com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory("Episode #31 - Vaccines, variants & doses", "https://youtu.be/uwGipawrJQo"));

        ListView listView = (ListView) findViewById(R.id.disclaimerListView);
        AdvisoryAdapter adapter = new AdvisoryAdapter(this, advisoryContent);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                com.daily_cases_reports.android.AdvisoryAdapterClass.Advisory advisory = advisoryContent.get(position);

                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(advisory.getUrl()));
                try {
                    Advisory.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}


//    Intent webIntent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse(advisory.getUrl()));
//                try {
//                    Disclaimer.this.startActivity(webIntent);
//                } catch (ActivityNotFoundException ex) {
//                    ex.printStackTrace();
//                }