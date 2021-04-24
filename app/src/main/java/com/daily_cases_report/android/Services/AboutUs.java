package com.daily_cases_report.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.daily_cases_report.android.R;

public class AboutUs extends AppCompatActivity {

    private String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.aboutus_action_bar);

        content = "\n\nThe content of this App is for information purposes. It gives real-time COVID-19 cases update worldwide, India, The United States. Our motto is to make awareness in our society about COVID-19 pandamic. \n" +
                "\n" +
                "\n" +
                "Most of the advisory content is from the World Health Organization (WHO), Ministry of health and family welfare and Indian Council of Medical Research (ICMR).\n" +
                "\n" +
                "\n" +
                "We are issue this App and it's content fighting against the pandemic of COVID-19. All advisory information publish through this App is guidelines only. App users are advised to follow local rules and regulations, Health safety requirement of respective authority on any  issue dealing with COVID-19 and their response.\n" +
                "\n" +
                "\n" +
                "The creator of this App nor the publication platform will not be responsible for any unforeseen circumstances for the same.\n"+
                "\n"+
                "\n"+
                "All the images by ICONS8 Via https://icons8.com Copyright-free and also Splash Screen And app icon by Pngtree Via  https://pngtree.com/ Copyright-free.";


        TextView textView = findViewById(R.id.aboutUsContent);
        textView.setText(content);

    }
}