package com.daily_cases_reports.android.UtilitiesIndia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daily_cases_reports.android.R;

import java.text.DecimalFormat;
import java.util.List;

public class CaseAdapterIndia extends ArrayAdapter<CaseDataIndia> {

    public CaseAdapterIndia(Context context, List<CaseDataIndia> casesData) {
        super(context, 0, casesData);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CaseDataIndia itemPosition = (CaseDataIndia) getItem(position);

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.custom_cases_india_layout, parent, false);
        }


        DecimalFormat formatter = new DecimalFormat("#,###");


        TextView StateNameIndiaTextView = listView.findViewById(R.id.StateNameIndia);
        StateNameIndiaTextView.setText(itemPosition.getState());

        TextView totalCasesIndiaTextView = listView.findViewById(R.id.totalCasesIndia);
        totalCasesIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalCases()))));

        TextView newCasesIndiaTextView = listView.findViewById(R.id.newCasesIndia);
        newCasesIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getNewCases()))));

        TextView totalDeathsIndiaTextView = listView.findViewById(R.id.totalDeathsIndia);
        totalDeathsIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalDeaths()))));

        TextView newDeathsIndiaTextView = listView.findViewById(R.id.newDeathsIndia);
        newDeathsIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getNewDeaths()))));

        TextView totalRecoveredIndiaTextView = listView.findViewById(R.id.totalRecoveredIndia);
        totalRecoveredIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalRecovered()))));

        TextView activeCasesIndiaTextView = listView.findViewById(R.id.activeCasesIndia);
        activeCasesIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getActiveCases()))));

        return listView;
    }
}
