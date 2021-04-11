package com.covidupdate.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.covidupdate.android.DetailCustomLayout;
import com.covidupdate.android.R;
import com.covidupdate.android.Utilities.CasesAdapter;
import com.covidupdate.android.Utilities.CasesData;
import com.covidupdate.android.Utilities.CasesLoader;

import java.util.ArrayList;
import java.util.List;

public class WorldWideCases extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CasesData>> {

    private static final String WORLDWIDECASES_JSON_RESPONSE = "https://disease.sh/v3/covid-19/countries?yesterday=false&twoDaysAgo=false&sort=cases&allowNull=0";
    public CasesAdapter WorldWideCasesAdapter;
    private static final int WorldWide_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_wide_cases);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.worldwide_action_bar);


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
    }

    @Override
    public void onLoaderReset(Loader<List<CasesData>> loader) {
        WorldWideCasesAdapter.clear();
    }

}