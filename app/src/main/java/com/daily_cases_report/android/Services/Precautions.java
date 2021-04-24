package com.daily_cases_report.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.daily_cases_report.android.ImageAdapter.ImageViewAdapter;
import com.daily_cases_report.android.R;

public class Precautions extends AppCompatActivity {

    private  String stayHomeSteps;
    private String handWash;
    private String socialDistancing;
    private String coverMouth;
    private String disinfect;

    private TextView stayHomeStepstextView;
    private TextView handWashtextView;
    private TextView socialDistancingtextView;
    private TextView coverMouthtextView;
    private TextView disinfecttextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.precautions_action_bar);


        ViewPager viewPager = findViewById(R.id. VP);
        ImageViewAdapter imageViewAdapter = new ImageViewAdapter(this);
        viewPager.setAdapter(imageViewAdapter);


        stayHomeSteps = "1. Stay Home\n\n2. KEEP a safe distance\n\n3. WASH hands often\n\n4. COVER your cough\n\n5. SICK? call the helpline\n\n\n\nHow to Protect Yourself and Other from the spread" ;

//        handWash = "Wash your hands often with soap and water\n" +
//                "for at least 20 seconds, especially after being\n" +
//                "in a public place, or after blowing your nose,\n" +
//                "coughing or sneezing\n\n" +
//                "If soap and water are not readily available,\n" +
//                "use a hand sanitizer with at least 60%\n" +
//                "alcohol.Avoid touching your eyes, nose and\n" +
//                "mouth with unwashed hands.";

        handWash = "\n" +
                "Wash your hands often with soap and water for at least 20 seconds, especially after being in a public place, or after blowing your nose, coughing or sneezing If soap and water are not readily available, use a hand sanitizer with at least 60% alcohol.Avoid touching your eyes, nose and mouth with unwashed hands.";


//        socialDistancing = "Avoid close contact with people who are sick\n" +
//                "Some people without symptoms may be able\n" +
//                "to spread the virus Stay home as much as\n" +
//                "possible and avoid non - essential travel.\n\n" +
//                "Practice social distancing by keeping at least\n" +
//                "6 feet - about two arm lengths - away from\n" +
//                "others if you must go out in public.";

        socialDistancing = "Avoid close contact with people who are sick Some people without symptoms may be able to spread the virus Stay home as much as possible and avoid non-essential travel. Practice social distancing by keeping at least 6 feet - about two arm lengths-away from others if you must go out in public.";


        /*coverMouth = "Cover your mouth and nose with a cloth face\n" +
                "cover when around others and when you\n" +
                "must go out in public, such as to a grocery\n" +
                "store. The cloth face cover is meant to\n" +
                "protect other people in case you are infected.\n" +
                "However, do NOT place cloth face coverings\n" +
                "on young children under age 2, anyone who\n" +
                "has trouble breathing, or is unconscious,\n" +
                "incapacitated or otherwise unable to remove\n" +
                "the mask without assistance In addition do\n" +
                "NOT use a facemask meant for a health care worker\n\n" +
                "Continue to keep about 6 feet between\n" +
                "yourself and others. The cloth face cover is\n" +
                "not a substitute for social distancing.";*/

        coverMouth = "\n" +
                "Cover your mouth and nose with a cloth face cover when around others and when you must go out in public, such as to a grocery store. The cloth face cover is meant to protect other people in case you are infected. However, do NOT place cloth face coverings on young children under age 2, anyone who has trouble breathing, or is unconscious, incapacitated or otherwise unable to remove the mask without assistance In addition do NOT use a facemask meant for a health care worker Continue to keep about 6 feet between yourself and others. The cloth face cover is not a substitute for social distancing.";



        disinfect = "This includes tables, doorknobs, light switches, countertops, handles, desks, phones, keyboards, toilets, faucets and sinks";

        stayHomeStepstextView = (TextView) findViewById(R.id.stayHomeSteps);
        stayHomeStepstextView.setText(stayHomeSteps);

        handWashtextView = (TextView) findViewById(R.id.Handwash);
        handWashtextView.setText(handWash);

        socialDistancingtextView = (TextView) findViewById(R.id.socialDistancingSteps);
        socialDistancingtextView.setText(socialDistancing);

        coverMouthtextView = (TextView) findViewById(R.id.coverMouthSteps);
        coverMouthtextView.setText(coverMouth);

        disinfecttextView = (TextView) findViewById(R.id.disinfectSteps);
        disinfecttextView.setText(disinfect);


    }
}