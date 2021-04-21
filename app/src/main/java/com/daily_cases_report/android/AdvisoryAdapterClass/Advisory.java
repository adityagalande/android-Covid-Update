package com.daily_update_of_covid_cases.android.AdvisoryAdapterClass;

public class Advisory {

    private final String title;
    private final String url;

    public Advisory(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle(){
        return this.title;
    }

    public String getUrl(){
        return this.url;
    }

}
