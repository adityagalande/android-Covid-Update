package com.daily_cases_reports.android.AdvisoryAdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.daily_cases_reports.android.R;

import java.util.ArrayList;

public class AdvisoryAdapter extends ArrayAdapter<Advisory> {
    public AdvisoryAdapter(@NonNull Context context, ArrayList<Advisory> advisories) {
        super(context, 0, advisories);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Advisory itemPosition = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_advisory_video_layout, parent, false);
        }

        TextView titleText = (TextView) listItemView.findViewById(R.id.video_title);
        titleText.setText(itemPosition.getTitle());

        return listItemView;
    }
}
