package com.daily_cases_update.android.Services;

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

import com.daily_cases_update.android.DetailCustomUsaLayout;
import com.daily_cases_update.android.R;
import com.daily_cases_update.android.UtilitiesUnitedStates.CaseAdapterUnitedStates;
import com.daily_cases_update.android.UtilitiesUnitedStates.CaseLoaderUnitedStates;
import com.daily_cases_update.android.UtilitiesUnitedStates.CasesDataUnitedStates;

import java.util.ArrayList;
import java.util.List;

public class AmericaCases extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CasesDataUnitedStates>>{

//    private AdView mAdView;
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


        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        ListView UnitedStateslistView = (ListView) findViewById(R.id.UnitedStatesList);
        caseAdapterUnitedStates = new CaseAdapterUnitedStates(this, new ArrayList<CasesDataUnitedStates>());
        UnitedStateslistView.setAdapter(caseAdapterUnitedStates);

        UnitedStateslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CasesDataUnitedStates casesDataUnitedStates = (CasesDataUnitedStates) (UnitedStateslistView.getItemAtPosition(position));

                Intent intent = new Intent(getApplicationContext(), DetailCustomUsaLayout.class);
                intent.putExtra("stateName", casesDataUnitedStates.getStateName());
                intent.putExtra("totalCases", casesDataUnitedStates.getTotalCases());
                intent.putExtra("totalDeaths", casesDataUnitedStates.getTotalDeaths());
                intent.putExtra("totalRecovered", casesDataUnitedStates.getTotalRecovered());
                intent.putExtra("activeCases", casesDataUnitedStates.getActiveCases());

                startActivity(intent);
            }
        });



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