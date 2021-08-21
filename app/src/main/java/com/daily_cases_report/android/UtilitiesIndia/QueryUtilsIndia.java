package com.daily_cases_report.android.UtilitiesIndia;

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

public class QueryUtilsIndia {
    public static ArrayList<CaseDataIndia> fetchCaseDataIndia(String requestUrl) {
        URL url = createURL(requestUrl);

        String jsonResponse = null;

        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<CaseDataIndia> caseDataIndias = extractFromJson(jsonResponse);
        return caseDataIndias;
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

    private static ArrayList<CaseDataIndia> extractFromJson(String casesJson) {
        if (TextUtils.isEmpty(casesJson)) {
            return null;
        }

        ArrayList<CaseDataIndia> CaseDataIndiaArrayListData = new ArrayList<>();
        try {

            JSONArray baseJsonObject = new JSONArray(casesJson);
            for (int i = 0; i < baseJsonObject.length(); i++) {
                JSONObject currentJsonObject = baseJsonObject.getJSONObject(i);
                String countryName = currentJsonObject.getString("country");


                if (countryName.equals("India")) {
                    String updatedAt = currentJsonObject.getString("updatedAt");
                    String state = currentJsonObject.getString("province");

                    JSONObject statsObject = currentJsonObject.getJSONObject("stats");
                    long totalCases = statsObject.getLong("confirmed");
                    long totalDeaths = statsObject.getLong("deaths");
//                    long totalRecovered = statsObject.getLong("recovered");
                    if (!state.equals("Unknown")) {

                        CaseDataIndia caseDataIndia = new CaseDataIndia(countryName, state, totalCases, totalDeaths, 20, updatedAt);
                        CaseDataIndiaArrayListData.add(caseDataIndia);
                    }
                }

            }

            return CaseDataIndiaArrayListData;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return CaseDataIndiaArrayListData;
    }

}
