package com.covidupdate.android.Utilities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.covidupdate.android.R;

import java.text.DecimalFormat;
import java.util.List;

public class CasesAdapter extends ArrayAdapter {

    public CasesAdapter(Context context, List<CasesData> casesData) {
        super(context, 0, casesData);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CasesData itemPosition = (CasesData) getItem(position);

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.custom_cases_layout, parent, false);
        }


        DecimalFormat formatter = new DecimalFormat("#,###");

        TextView countryNameTextView = listView.findViewById(R.id.CountryName);
        countryNameTextView.setText(itemPosition.getCountryName());

        TextView totalCasesTextView = listView.findViewById(R.id.totalCases);
        totalCasesTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalCases()))));

        TextView newcasesTextView = listView.findViewById(R.id.newCases);
        if (itemPosition.getNewCases() == 0) {
            newcasesTextView.setText("");
        } else {
            newcasesTextView.setText("+" + formatter.format(Double.parseDouble(String.valueOf(itemPosition.getNewCases()))));
        }

        TextView totalDeathsTextView = listView.findViewById(R.id.totalDeaths);
        if (itemPosition.getTotalDeaths() == 0) {
            totalDeathsTextView.setText("");
        } else {
            totalDeathsTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalDeaths()))));
        }

        TextView newDeathsTextView = listView.findViewById(R.id.newDeaths);
        if (itemPosition.getNewDeaths() == 0) {
            newDeathsTextView.setText("");
        } else {
            newDeathsTextView.setText("+" + formatter.format(Double.parseDouble(String.valueOf(itemPosition.getNewDeaths()))));
        }

        TextView totalRecoveredTextView = listView.findViewById(R.id.totalRecovered);
        totalRecoveredTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalRecovered()))));

        TextView newRwcoveredTextView = listView.findViewById(R.id.newRecovered);
        if (itemPosition.getNewRecovered() == 0) {
            newRwcoveredTextView.setText("");
        } else {
            newRwcoveredTextView.setText("+" + formatter.format(Double.parseDouble(String.valueOf(itemPosition.getNewRecovered()))));
        }

        TextView activeCasesTextView = listView.findViewById(R.id.activeCases);
        if (itemPosition.getActiveCases() == 0) {
            activeCasesTextView.setText("");
        } else {
            activeCasesTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getActiveCases()))));
        }

        TextView seriousCasesTextView = listView.findViewById(R.id.seriousCases);
        if (itemPosition.getSeriousCases() == 0) {
            seriousCasesTextView.setText("");
        } else {
            seriousCasesTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getSeriousCases()))));
        }

        TextView totalTestsTextView = listView.findViewById(R.id.totalTests);
        if (itemPosition.getTotalTests() == 0) {
            totalTestsTextView.setText("");
        } else {
            totalTestsTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalTests()))));
        }

        TextView populationTextView = listView.findViewById(R.id.population);
        if (itemPosition.getPopulation() == 0) {
            populationTextView.setText("");
        } else {
            populationTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getPopulation()))));
        }

        return listView;
    }

}
