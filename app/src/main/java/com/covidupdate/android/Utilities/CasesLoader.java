package com.covidupdate.android.Utilities;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class CasesLoader extends AsyncTaskLoader<List<CasesData>> {

    private final String url;

    public CasesLoader(@NonNull Context context, String url) {
        super(context);
        this.url = url;

    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<CasesData> loadInBackground() {
        if (url == null){
            return null;
        }
        List<CasesData> cases = QueryUtils.fetchCasesData(url);
        return cases;
    }
}
