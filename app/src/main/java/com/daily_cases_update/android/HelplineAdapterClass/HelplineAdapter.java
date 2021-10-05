package com.daily_cases_update.android.HelplineAdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.daily_cases_update.android.R;

import java.util.ArrayList;

public class HelplineAdapter extends ArrayAdapter<Helpline> {

    public HelplineAdapter(@NonNull Context context, ArrayList<Helpline> helplines) {
        super(context, 0, helplines);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Helpline itemPosition = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_helpline_layout, parent, false);
        }


        TextView srNoTextView = (TextView) listItemView.findViewById(R.id.sr_no);
        srNoTextView.setText(itemPosition.getSR_NO());

        TextView stateNameTextView = (TextView) listItemView.findViewById(R.id.state_name);
        stateNameTextView.setText(itemPosition.getState_Name());

        TextView helplineTextView = (TextView) listItemView.findViewById(R.id.helpline_number);
        helplineTextView.setText(itemPosition.getHelpline_Number());

        return listItemView;

    }
}
