package com.covidupdate.android.Utilities;

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

public class QueryUtils {

    public static ArrayList<CasesData> fetchCasesData(String requestUrl) {
        URL url = createURL(requestUrl);

        String jsonResponse = null;

        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<CasesData> casesData = extractFromJson(jsonResponse);
        return casesData;
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

    private static ArrayList<CasesData> extractFromJson(String casesJson) {
        if (TextUtils.isEmpty(casesJson)) {
            return null;
        }

        ArrayList<CasesData> casesDataArrayListData = new ArrayList<>();
        try {
            JSONArray baseJsonObject = new JSONArray(casesJson);
            for (int i = 0; i < baseJsonObject.length(); i++) {
                JSONObject currentJsonObject = baseJsonObject.getJSONObject(i);
                String countryName = currentJsonObject.getString("country");
                long totalCases = currentJsonObject.getLong("cases");
                long newCases = currentJsonObject.getLong("todayCases");
                long totalDeaths = currentJsonObject.getLong("deaths");
                long newlDeaths = currentJsonObject.getLong("todayDeaths");
                long totalRecovered = currentJsonObject.getLong("recovered");
                long newRecovered = currentJsonObject.getLong("todayRecovered");
                long activeCases = currentJsonObject.getLong("active");
                long seriousCases = currentJsonObject.getLong("critical");
                long totalTests = currentJsonObject.getLong("tests");
                long population = currentJsonObject.getLong("population");

                JSONObject countryInfo = currentJsonObject.getJSONObject("countryInfo");
                String flagImg = countryInfo.getString("flag");


                CasesData casesData = new CasesData(countryName, flagImg, totalCases, newCases, totalDeaths, newlDeaths, totalRecovered, newRecovered, activeCases, seriousCases, totalTests, population);
                casesDataArrayListData.add(casesData);

            }

            return casesDataArrayListData;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return casesDataArrayListData;
    }

}
