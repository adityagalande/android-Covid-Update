package com.daily_cases_update.android.UtilitiesUnitedStates;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daily_cases_update.android.R;

import java.text.DecimalFormat;
import java.util.List;

public class CaseAdapterUnitedStates extends ArrayAdapter {

    public CaseAdapterUnitedStates(Context context, List<CasesDataUnitedStates> casesDataUnitedStates) {
        super(context, 0, casesDataUnitedStates);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CasesDataUnitedStates itemPosition = (CasesDataUnitedStates) getItem(position);

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.custom_cases_united_states_layout, parent, false);
        }

        DecimalFormat formatter = new DecimalFormat("#,###");

        TextView stateNameTextView = listView.findViewById(R.id.stateName);
        stateNameTextView.setText(itemPosition.getStateName());

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

        TextView activeCasesTextView = listView.findViewById(R.id.activeCases);
        if (itemPosition.getActiveCases() == 0) {
            activeCasesTextView.setText("");
        } else {
            activeCasesTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getActiveCases()))));
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
