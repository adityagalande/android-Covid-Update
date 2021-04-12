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
import com.covidupdate.android.UtilitiesIndia.CaseAdapterIndia;
import com.covidupdate.android.UtilitiesIndia.CaseDataIndia;
import com.covidupdate.android.UtilitiesIndia.CaseLoaderIndia;

import java.util.ArrayList;
import java.util.List;

public class IndiaCases extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CaseDataIndia>>{

    private static final String INDIA_JSON_RESPONSE = "https://disease.sh/v3/covid-19/jhucsse";
    public CaseAdapterIndia IndiaCasesAdapter;
    private static final int INDIA_LOADER_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_cases);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.india_action_bar);

        ListView WorldWidelistView = (ListView) findViewById(R.id.IndiaList);
        IndiaCasesAdapter = new CaseAdapterIndia(this, new ArrayList<CaseDataIndia>());
        WorldWidelistView.setAdapter(IndiaCasesAdapter);

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
    }

    @Override
    public void onLoaderReset(Loader<List<CaseDataIndia>> loader) {
        IndiaCasesAdapter.clear();
    }
}