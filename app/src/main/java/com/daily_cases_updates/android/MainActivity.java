package com.daily_cases_updates.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daily_cases_updates.android.Services.AboutUs;
import com.daily_cases_updates.android.Services.AmericaCases;
import com.daily_cases_updates.android.Services.Advisory;
import com.daily_cases_updates.android.Services.Helpline;
import com.daily_cases_updates.android.Services.IndiaCases;
import com.daily_cases_updates.android.Services.MaskTips;
import com.daily_cases_updates.android.Services.Precautions;
import com.daily_cases_updates.android.Services.Suggestions;
import com.daily_cases_updates.android.Services.WorldWideCases;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Objects;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout helpLineView;
    private RelativeLayout masktipsView;
    private RelativeLayout precautionsView;
    private RelativeLayout suggestionView;
    private RelativeLayout rateusView;
    private RelativeLayout disclaimerView;
    private RelativeLayout aboutusView;
    private RelativeLayout worldwidecasesView;
    private RelativeLayout indiacasesView;
    private RelativeLayout americaView;
    private LinearLayout globalUpdateLinearLayout;
    private ProgressBar mLoadingIndicator;
    private RelativeLayout offlineViewRelativeLayout;

    GlobalCasesAsyncTask globalCasesAsyncTask;
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String Get_Global_Cases_URL = "https://disease.sh/v3/covid-19/all?yesterday=false&twoDaysAgo=false&allowNull=0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }

        //App Ratings
        AppRate.with(this)
                .setInstallDays(1)
                .setLaunchTimes(3)
                .setRemindInterval(1)
                .monitor();
        AppRate.showRateDialogIfMeetsConditions(this);




        globalUpdateLinearLayout = (LinearLayout) findViewById(R.id.globalUpdate);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
        offlineViewRelativeLayout = (RelativeLayout) findViewById(R.id.offline_view);


        helpLineView = (RelativeLayout) findViewById(R.id.helpline_view);
        masktipsView = (RelativeLayout) findViewById(R.id.masktips_view);
        precautionsView = (RelativeLayout) findViewById(R.id.precautionary__view);
        suggestionView = (RelativeLayout) findViewById(R.id.suggestion_view);
        rateusView = (RelativeLayout) findViewById(R.id.rate_us_view);
        disclaimerView = (RelativeLayout) findViewById(R.id.disclaimer_view);
        aboutusView = (RelativeLayout) findViewById(R.id.about_us_view);
        worldwidecasesView = (RelativeLayout) findViewById(R.id.worldWideCases);
        indiacasesView = (RelativeLayout) findViewById(R.id.indiaCases);
        americaView = (RelativeLayout) findViewById(R.id.americaCases);

        RelativeLayout actionBarMainScreenRelativeLayout = (RelativeLayout) findViewById(R.id.refreshButton);
        setOnClickListenerForButton();

        globalCasesAsyncTask = new GlobalCasesAsyncTask();
        globalCasesAsyncTask.execute();

        checkConnection();
        showLoading();

        actionBarMainScreenRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Daily Cases Update");
                    String shareMSG = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    intent.putExtra(Intent.EXTRA_TEXT,shareMSG);
                    startActivity(Intent.createChooser(intent, "share by"));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showLoading() {
        /* Then, hide the weather data */
        globalUpdateLinearLayout.setVisibility(View.INVISIBLE);
        /* Finally, show the loading indicator */
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }


    private void showGlobalUpdateView() {
        /* First, hide the loading indicator */
        mLoadingIndicator.setVisibility(View.INVISIBLE);
        /* Finally, make sure the weather data is visible */
        globalUpdateLinearLayout.setVisibility(View.VISIBLE);
    }


    public void checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null) {
        } else {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            globalUpdateLinearLayout.setVisibility(View.INVISIBLE);
            offlineViewRelativeLayout.setVisibility(View.VISIBLE);
//            Toast.makeText(MainActivity.this, "Oops! Internet Connection Lost", Toast.LENGTH_LONG).show();
        }
    }


    private void setOnClickListenerForButton() {

        helpLineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpline = new Intent(MainActivity.this, Helpline.class);
                startActivity(helpline);
            }
        });

        masktipsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masktips = new Intent(MainActivity.this, MaskTips.class);
                startActivity(masktips);
            }
        });

        precautionsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent precautions = new Intent(MainActivity.this, Precautions.class);
                startActivity(precautions);
            }
        });

        suggestionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent suggestion = new Intent(MainActivity.this, Suggestions.class);
                startActivity(suggestion);
            }
        });

        rateusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        disclaimerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disclaimer = new Intent(MainActivity.this, Advisory.class);
                startActivity(disclaimer);
            }
        });

        aboutusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutus = new Intent(MainActivity.this, AboutUs.class);
                startActivity(aboutus);
            }
        });

        worldwidecasesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent worldwidecases = new Intent(MainActivity.this, WorldWideCases.class);
                startActivity(worldwidecases);
            }
        });

        indiacasesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent indiacases = new Intent(MainActivity.this, IndiaCases.class);
                startActivity(indiacases);
            }
        });

        americaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent americacases = new Intent(MainActivity.this, AmericaCases.class);
                startActivity(americacases);
            }
        });
    }


    private void updateUI(Event event) {

        DecimalFormat formatter = new DecimalFormat("#,###");

        TextView casestextView = findViewById(R.id.casesMain);
        casestextView.setText(formatter.format(Double.parseDouble(String.valueOf(event.cases))));

        TextView deathtextView = findViewById(R.id.deathsMain);
        deathtextView.setText(formatter.format(Double.parseDouble(String.valueOf(event.deaths))));

        TextView recoveredtextView = findViewById(R.id.recoveredMain);
        recoveredtextView.setText(formatter.format(Double.parseDouble(String.valueOf(event.recovered))));
    }


    private class GlobalCasesAsyncTask extends AsyncTask<URL, Void, Event> {

        @Override
        protected Event doInBackground(URL... urls) {
            URL url = createUrl(Get_Global_Cases_URL);

            String jsonResponse = "";

            try {
                jsonResponse = makeHttpRequest(url);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Event GlobalCasesEvent = extractDataFromJson(jsonResponse);

            return GlobalCasesEvent;
        }

        @Override
        protected void onPostExecute(Event event) {
            if (event == null) {
                return;
            } else {
                showGlobalUpdateView();
                updateUI(event);
            }
        }


    }


    private URL createUrl(String get_global_cases_url_String) {
        URL url = null;

        try {
            url = new URL(get_global_cases_url_String);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL", e);
            return null;
        }
        return url;
    }


    private String makeHttpRequest(URL url) throws IOException {

        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }


    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }


    private Event extractDataFromJson(String jsonResponse) {

        try {
            JSONObject baseJsonObject = new JSONObject(jsonResponse);

            long cases = baseJsonObject.getLong("cases");
            long deaths = baseJsonObject.getLong("deaths");
            long recovered = baseJsonObject.getLong("recovered");

            return new Event(cases, deaths, recovered);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}