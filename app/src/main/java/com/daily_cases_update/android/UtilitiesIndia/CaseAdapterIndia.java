package com.daily_cases_update.android.UtilitiesIndia;

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
        StateNameIndiaTextView.setText(itemPosition.getProvinceName());

        TextView totalCasesIndiaTextView = listView.findViewById(R.id.totalCasesIndia);
        totalCasesIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getConfirmedtotalCases()))));

        TextView totalDeathsIndiaTextView = listView.findViewById(R.id.totalDeathsIndia);
        totalDeathsIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalDeaths()))));


//        Temporaryly off----------------------->

//        TextView totalRecoveredIndiaTextView = listView.findViewById(R.id.totalRecoveredIndia);
//        totalRecoveredIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getTotalRecovered()))));
//
//        TextView activeCasesIndiaTextView = listView.findViewById(R.id.ActiveCasesIndia);
//        activeCasesIndiaTextView.setText(formatter.format(Double.parseDouble(String.valueOf(itemPosition.getActiveCases()))));

        TextView updatedDateIndiaTextView = listView.findViewById(R.id.updatedDateIndia);
        updatedDateIndiaTextView.setText(itemPosition.getUpdatedAtDate());

        return listView;
    }
}
