package com.covidupdate.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.covidupdate.android.R;
import com.covidupdate.android.Utilities.CasesAdapter;
import com.covidupdate.android.Utilities.CasesData;
import com.covidupdate.android.Utilities.CasesLoader;
import com.covidupdate.android.UtilitiesUnitedStates.CaseAdapterUnitedStates;
import com.covidupdate.android.UtilitiesUnitedStates.CaseLoaderUnitedStates;
import com.covidupdate.android.UtilitiesUnitedStates.CasesDataUnitedStates;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class AmericaCases extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CasesDataUnitedStates>>{

    private AdView mAdView;
    private static final String UNITEDSTATES_JSON_RESPONSE = "https://disease.sh/v3/covid-19/states?sort=cases&yesterday=false&allowNull=0";
    public CaseAdapterUnitedStates caseAdapterUnitedStates;
    private static final int UnitedStates_LOADER_ID = 3;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_america_cases);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.usa_action_bar);

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

        ListView UnitedStateslistView = (ListView) findViewById(R.id.UnitedStatesList);
        caseAdapterUnitedStates = new CaseAdapterUnitedStates(this, new ArrayList<CasesDataUnitedStates>());
        UnitedStateslistView.setAdapter(caseAdapterUnitedStates);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(UnitedStates_LOADER_ID, null, this);
    }

    @Override
    public Loader<List<CasesDataUnitedStates>> onCreateLoader(int id, Bundle args) {
        return new CaseLoaderUnitedStates(this, UNITEDSTATES_JSON_RESPONSE);
    }

    @Override
    public void onLoadFinished(Loader<List<CasesDataUnitedStates>> loader, List<CasesDataUnitedStates> data) {
        caseAdapterUnitedStates.clear();
        if (data != null && !data.isEmpty()) {
            caseAdapterUnitedStates.addAll(data);
        }
        mLoadingIndicator.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<List<CasesDataUnitedStates>> loader) {
        caseAdapterUnitedStates.clear();
    }
}