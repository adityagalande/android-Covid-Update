package com.covidupdate.android.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.covidupdate.android.R;

import java.util.List;

public class CasesAdapter extends ArrayAdapter {

    public CasesAdapter(@NonNull Context context, @NonNull List<CasesData> casesData) {
        super(context, 0, casesData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CasesData itemPosition = (CasesData) getItem(position);

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.custom_cases_layout, parent, false);
        }


        TextView SrNoTextView = listView.findViewById(R.id.sr_no);
        SrNoTextView.setText(String.valueOf(itemPosition.getSrNo()));

        TextView countryNameTextView = listView.findViewById(R.id.CountryName);
        countryNameTextView.setText(itemPosition.getCountryName());

        TextView totalCasesTextView = listView.findViewById(R.id.totalCases);
        totalCasesTextView.setText(String.valueOf(itemPosition.getTotalCases()));

        TextView newcasesTextView = listView.findViewById(R.id.newCases);
        newcasesTextView.setText(String.valueOf(itemPosition.getNewCases()));

        TextView totalDeathsTextView = listView.findViewById(R.id.totalDeaths);
        totalDeathsTextView.setText(String.valueOf(itemPosition.getTotalDeaths()));

        TextView newDeathsTextView = listView.findViewById(R.id.newDeaths);
        newDeathsTextView.setText(String.valueOf(itemPosition.getNewDeaths()));

        TextView totalRecoveredTextView = listView.findViewById(R.id.totalRecovered);
        totalRecoveredTextView.setText(String.valueOf(itemPosition.getTotalRecovered()));

        TextView newRwcoveredTextView = listView.findViewById(R.id.newRecovered);
        newRwcoveredTextView.setText(String.valueOf(itemPosition.getNewRecovered()));

        TextView activeCasesTextView = listView.findViewById(R.id.activeCases);
        activeCasesTextView.setText(String.valueOf(itemPosition.getActiveCases()));

        TextView seriousCasesTextView = listView.findViewById(R.id.seriousCases);
        seriousCasesTextView.setText(String.valueOf(itemPosition.getSeriousCases()));

        TextView totalTestsTextView = listView.findViewById(R.id.totalTests);
        totalTestsTextView.setText(String.valueOf(itemPosition.getTotalTests()));

        TextView populationTextView = listView.findViewById(R.id.population);
        populationTextView.setText(String.valueOf(itemPosition.getPopulation()));

        return listView;
    }
}
