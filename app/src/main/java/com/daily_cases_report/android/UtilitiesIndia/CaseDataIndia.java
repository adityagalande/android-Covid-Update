package com.daily_cases_report.android.UtilitiesIndia;

public class CaseDataIndia {

    private final String countryName;
    private final String provinceName;
    private final long confirmedtotalCases;
    private final long totalDeaths;
    private final long totalRecovered;
    private final String updatedAtDate;

    public CaseDataIndia(String countryName, String provinceName, long confirmedtotalCases, long totalDeaths, long totalRecovered, String updatedAtDate) {
        this.countryName = countryName;
        this.provinceName = provinceName;
        this.confirmedtotalCases = confirmedtotalCases;
        this.totalDeaths = totalDeaths;
        this.totalRecovered = totalRecovered;
        this.updatedAtDate = updatedAtDate;
    }

    public String getCountryName() { return this.countryName; }

    public String getProvinceName(){
        return this.provinceName;
    }

    public long getConfirmedtotalCases(){
        return this.confirmedtotalCases;
    }

    public long getTotalDeaths(){
        return this.totalDeaths;
    }

    public long getTotalRecovered(){ return this.totalRecovered; }

    public String getUpdatedAtDate(){
        return this.updatedAtDate;
    }

    public long getActiveCases() {
        return confirmedtotalCases - (totalDeaths + totalRecovered);
    }
}
