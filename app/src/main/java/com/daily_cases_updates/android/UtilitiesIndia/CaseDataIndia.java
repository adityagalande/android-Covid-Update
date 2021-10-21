package com.daily_cases_updates.android.UtilitiesIndia;

public class CaseDataIndia {

//    private final String countryName;
//    private final String provinceName;
//    private final long confirmedtotalCases;
//    private final long totalDeaths;
//    private final long totalRecovered;
//    private final String updatedAtDate;


    private final String state;
    private final long totalCases;
    private final long newCases;
    private final long totalDeaths;
    private final long newDeaths;
    private final long totalRecovered;
    private final long activeCases;


    public CaseDataIndia(String state, long totalCases, long newCases, long totalDeaths, long newDeaths, long totalRecovered, long activeCases) {
        this.state = state;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.activeCases = activeCases;
    }

    public String getState() { return this.state; }
    public long getTotalCases() { return this.totalCases; }
    public long getNewCases() { return this.newCases; }
    public long getTotalDeaths() { return this.totalDeaths; }
    public long getNewDeaths() { return this.newDeaths; }
    public long getTotalRecovered() { return this.totalRecovered; }
    public long getActiveCases() { return this.activeCases; }

//    public String getCountryName() { return this.countryName; }
//
//    public String getProvinceName(){
//        return this.provinceName;
//    }
//
//    public long getConfirmedtotalCases(){
//        return this.confirmedtotalCases;
//    }
//
//    public long getTotalDeaths(){
//        return this.totalDeaths;
//    }
//
//    public long getTotalRecovered(){ return this.totalRecovered; }
//
//    public String getUpdatedAtDate(){
//        return this.updatedAtDate;
//    }
//
//    public long getActiveCases() {
//        return confirmedtotalCases - (totalDeaths + totalRecovered);
//    }
}
