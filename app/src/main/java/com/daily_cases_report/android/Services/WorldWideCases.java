package com.daily_cases_report.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.daily_cases_report.android.DetailCustomLayout;
import com.daily_cases_report.android.R;
import com.daily_cases_report.android.Utilities.CasesAdapter;
import com.daily_cases_report.android.Utilities.CasesData;
import com.daily_cases_report.android.Utilities.CasesLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class WorldWideCases extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CasesData>> {

    //Banner Ad
    private AdView mAdView;

    private static final String WORLDWIDECASES_JSON_RESPONSE = "https://disease.sh/v3/covid-19/countries?yesterday=false&twoDaysAgo=false&sort=cases&allowNull=0";
    public CasesAdapter WorldWideCasesAdapter;
    private static final int WorldWide_LOADER_ID = 1;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_wide_cases);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.worldwide_action_bar);

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


        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        ListView WorldWidelistView = (ListView) findViewById(R.id.WorldWideList);
        WorldWideCasesAdapter = new CasesAdapter(this, new ArrayList<CasesData>());
        WorldWidelistView.setAdapter(WorldWideCasesAdapter);

        WorldWidelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CasesData casesData = (CasesData) (WorldWidelistView.getItemAtPosition(position));

                Intent intent = new Intent(getApplicationContext(), DetailCustomLayout.class);
                intent.putExtra("countryName", casesData.getCountryName());
                intent.putExtra("countryIMG", casesData.getCountryIMG());
                intent.putExtra("totalCases", casesData.getTotalCases());
                intent.putExtra("totalDeaths", casesData.getTotalDeaths());
                intent.putExtra("totalRecovered", casesData.getTotalRecovered());
                intent.putExtra("activeCases", casesData.getActiveCases());
                intent.putExtra("seriousCases", casesData.getSeriousCases());

                startActivity(intent);
            }
        });


        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(WorldWide_LOADER_ID, null, this);

    }


    @Override
    public Loader<List<CasesData>> onCreateLoader(int id, Bundle args) {
        return new CasesLoader(this, WORLDWIDECASES_JSON_RESPONSE);
    }

    @Override
    public void onLoadFinished(Loader<List<CasesData>> loader, List<CasesData> data) {
        WorldWideCasesAdapter.clear();
        if (data != null && !data.isEmpty()) {
            WorldWideCasesAdapter.addAll(data);
        }
        mLoadingIndicator.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<List<CasesData>> loader) {
        WorldWideCasesAdapter.clear();
    }

}