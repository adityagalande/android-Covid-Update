package com.covidupdate.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.covidupdate.android.AdvisoryAdapterClass.Advisory;
import com.covidupdate.android.AdvisoryAdapterClass.AdvisoryAdapter;
import com.covidupdate.android.HelplineAdapterClass.HelplineAdapter;
import com.covidupdate.android.R;

import java.util.ArrayList;

public class Helpline extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.helpline_action_bar);


        final ArrayList<com.covidupdate.android.HelplineAdapterClass.Helpline> helplineContent = new ArrayList<>();

        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("1", "Andhra Pradesh", "0866-2410978"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("2", "Arunachal Pradesh", "9436055743"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("3", "Andaman and Nicobar", "03192-232102"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("4", "Assam", "6913347770"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("5", "Bihar", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("6", "Chhattisgarh", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("7", "Chandigarh", "9779558282"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("8", "Dadra Nagar Haveli & Daman Diu", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("9", "Delhi", "011-22307145"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("10", "Goa", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("11", "Gujarath", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("12", "Haryana ", "8558893911"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("13", "Himachal Pradesh", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("14", "Jammu & Kashmir", "01912520982,\n0194-2440283"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("15", "Jharkhand", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("16", "Karnataka", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("17", "Kerala", "0471-2552056"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("18", "Ladakh", "01982256462"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("19", "Lakshadweep", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("20", "Madhya Pradesh ", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("21", "Maharashtra", "020-26127394"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("22", "Manipur", "3852411668"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("23", "Meghalaya", "108"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("24", "Mizoram", "102"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("25", "Nagaland", "7005539653"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("26", "Odisha", "9439994859"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("27", "Puducherry ", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("28", "Punjab", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("29", "Rajasthan", "0141-2225624"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("30", "Sikkim", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("31", "Tamil Nadu", "044-29510500"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("32", "Telangana", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("33", "Tripura ", "0381-2315879"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("34", "Uttarakhand", "104"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("35", "Uttar Pradesh", "18001805145"));
        helplineContent.add(new com.covidupdate.android.HelplineAdapterClass.Helpline("36", "West Bengal", "1800313444222\n,03323412600"));


        ListView listView = (ListView) findViewById(R.id.helplineListView);
        HelplineAdapter adapter = new HelplineAdapter(this, helplineContent);
        listView.setAdapter(adapter);

    }
}