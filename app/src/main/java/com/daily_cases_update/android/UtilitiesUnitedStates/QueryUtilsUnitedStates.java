package com.daily_cases_update.android.UtilitiesUnitedStates;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
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
import java.util.ArrayList;

public class QueryUtilsUnitedStates {


    public static ArrayList<CasesDataUnitedStates> fetchCasesData(String requestUrl) {
        URL url = createURL(requestUrl);

        String jsonResponse = null;

        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<CasesDataUnitedStates> casesDataUnitedStates = extractFromJson(jsonResponse);
        return casesDataUnitedStates;
    }

    private static URL createURL(String urls) {
        URL url = null;
        try {
            url = new URL(urls);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = null;
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e("Error TAG.", "NOPE!!");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder stringBuilderOutput = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = br.readLine();
            while (line != null) {
                stringBuilderOutput.append(line);
                line = br.readLine();
            }
        }
        return stringBuilderOutput.toString();
    }

    private static ArrayList<CasesDataUnitedStates> extractFromJson(String casesJson) {
        if (TextUtils.isEmpty(casesJson)) {
            return null;
        }

        ArrayList<CasesDataUnitedStates> casesDataUnitedStatesArrayListData = new ArrayList<>();
        try {
            JSONArray baseJsonObject = new JSONArray(casesJson);
            for (int i = 0; i < baseJsonObject.length(); i++) {
                JSONObject currentJsonObject = baseJsonObject.getJSONObject(i);
                String stateName = currentJsonObject.getString("state");
                long totalCases = currentJsonObject.getLong("cases");
                long newCases = currentJsonObject.getLong("todayCases");
                long totalDeaths = currentJsonObject.getLong("deaths");
                long newlDeaths = currentJsonObject.getLong("todayDeaths");
                long totalRecovered = currentJsonObject.getLong("recovered");
                long activeCases = currentJsonObject.getLong("active");
                long totalTests = currentJsonObject.getLong("tests");
                long population = currentJsonObject.getLong("population");


                CasesDataUnitedStates casesDataUnitedStates = new CasesDataUnitedStates(stateName, totalCases, newCases, totalDeaths, newlDeaths, totalRecovered, activeCases, totalTests, population);
                casesDataUnitedStatesArrayListData.add(casesDataUnitedStates);

            }

            return casesDataUnitedStatesArrayListData;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return casesDataUnitedStatesArrayListData;
    }

}

