package com.covidupdate.android.UtilitiesUnitedStates;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class CaseLoaderUnitedStates extends AsyncTaskLoader<List<CasesDataUnitedStates>> {

    private String url;

    public CaseLoaderUnitedStates(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<CasesDataUnitedStates> loadInBackground() {
        if (url == null){
            return null;
        }
        List<CasesDataUnitedStates> casesDataUnitedStates = QueryUtilsUnitedStates.fetchCasesData(url);
        return casesDataUnitedStates;
    }
}
