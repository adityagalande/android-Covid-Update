package com.daily_cases_report.android.UtilitiesIndia;

import android.content.AsyncTaskLoader;
import android.content.Context;


import java.util.List;

public class CaseLoaderIndia extends AsyncTaskLoader<List<CaseDataIndia>> {


    private String url;

    public CaseLoaderIndia(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<CaseDataIndia> loadInBackground() {
        if (url == null) {
            return null;
        }
        List<CaseDataIndia> caseDataIndias = QueryUtilsIndia.fetchCaseDataIndia(url);
        return caseDataIndias;
    }
}
