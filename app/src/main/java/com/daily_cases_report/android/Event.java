package com.daily_update_of_covid_cases.android;

public class Event {
    public final long cases, deaths, recovered;


    public Event(long cases, long deaths, long recovered) {
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }


}
