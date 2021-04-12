package com.covidupdate.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ListView;

import com.covidupdate.android.R;
import com.covidupdate.android.Utilities.CasesAdapter;
import com.covidupdate.android.Utilities.CasesData;
import com.covidupdate.android.Utilities.CasesLoader;
import com.covidupdate.android.UtilitiesUnitedStates.CaseAdapterUnitedStates;
import com.covidupdate.android.UtilitiesUnitedStates.CaseLoaderUnitedStates;
import com.covidupdate.android.UtilitiesUnitedStates.CasesDataUnitedStates;

import java.util.ArrayList;
import java.util.List;

public class AmericaCases extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CasesDataUnitedStates>>{

    private static final String UNITEDSTATES_JSON_RESPONSE = "https://disease.sh/v3/covid-19/states?sort=cases&yesterday=false&allowNull=0";
    public CaseAdapterUnitedStates caseAdapterUnitedStates;
    private static final int UnitedStates_LOADER_ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_america_cases);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.usa_action_bar);

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
    }

    @Override
    public void onLoaderReset(Loader<List<CasesDataUnitedStates>> loader) {
        caseAdapterUnitedStates.clear();
    }
}