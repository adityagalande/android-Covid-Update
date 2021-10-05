package com.daily_cases_update.android.Utilities;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class CasesLoader extends AsyncTaskLoader<List<CasesData>> {

    private String url;

    public CasesLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<CasesData> loadInBackground() {
        if (url == null){
            return null;
        }
        List<CasesData> cases = QueryUtils.fetchCasesData(url);
        return cases;
    }
}
