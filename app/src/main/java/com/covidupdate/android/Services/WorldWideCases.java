package com.covidupdate.android.Services;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.widget.ListView;

import com.covidupdate.android.R;
import com.covidupdate.android.Utilities.CasesAdapter;
import com.covidupdate.android.Utilities.CasesData;

import java.util.ArrayList;
import java.util.List;

public class WorldWideCases extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CasesData>> {

    private static final String WORLDWIDECASES_JSON_RESPONSE = "https://disease.sh/v3/covid-19/countries?yesterday=false&twoDaysAgo=false&sort=cases&allowNull=false";
    private CasesAdapter WorldWideCasesAdapter;
    private static final int WorldWide_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_wide_cases);

        ListView WorldWidelistView = (ListView) findViewById(R.id.WorldWideList);
        WorldWideCasesAdapter = new CasesAdapter(this, new ArrayList<CasesData>());
        WorldWidelistView.setAdapter(WorldWideCasesAdapter);

    }







    @NonNull
    @Override
    public Loader<List<CasesData>> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<CasesData>> loader, List<CasesData> data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<CasesData>> loader) {

    }
}