package com.covidupdate.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.covidupdate.android.R;
import com.covidupdate.android.UtilitiesIndia.CaseAdapterIndia;
import com.covidupdate.android.UtilitiesIndia.CaseDataIndia;
import com.covidupdate.android.UtilitiesIndia.CaseLoaderIndia;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class IndiaCases extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CaseDataIndia>> {

    private AdView mAdView;
    private static final String INDIA_JSON_RESPONSE = "https://disease.sh/v3/covid-19/jhucsse";
    public CaseAdapterIndia IndiaCasesAdapter;
    private static final int INDIA_LOADER_ID = 2;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_cases);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.india_action_bar);

        //Ad Mob code
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9365499454983010/9733226421");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        ListView indialistView = (ListView) findViewById(R.id.IndiaList);
        IndiaCasesAdapter = new CaseAdapterIndia(this, new ArrayList<CaseDataIndia>());
        indialistView.setAdapter(IndiaCasesAdapter);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(INDIA_LOADER_ID, null, this);
    }

    @Override
    public Loader<List<CaseDataIndia>> onCreateLoader(int id, Bundle args) {

        return new CaseLoaderIndia(this, INDIA_JSON_RESPONSE);
    }

    @Override
    public void onLoadFinished(Loader<List<CaseDataIndia>> loader, List<CaseDataIndia> data) {
        IndiaCasesAdapter.clear();
        if (data != null && !data.isEmpty()) {
            IndiaCasesAdapter.addAll(data);
        }
        mLoadingIndicator.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<List<CaseDataIndia>> loader) {
        IndiaCasesAdapter.clear();
    }

}