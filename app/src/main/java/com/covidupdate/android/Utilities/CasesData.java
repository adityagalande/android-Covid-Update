package com.covidupdate.android.Utilities;

public class CasesData {

    private final long SrNo;
    private final String countryName;
    private final String countryIMG;
    private final long totalCases;
    private final long newCases;
    private final long totalDeaths;
    private final long newDeaths;
    private final long totalRecovered;
    private final long newRecovered;
    private final long activeCases;
    private final long seriousCases;
    private final long totalTests;
    private final long population;

    public CasesData(long srNo, String countryName, String countryIMG, long totalCases, long newCases, long totalDeaths, long newDeaths, long totalRecovered, long newRecovered, long activeCases, long seriousCases, long totalTests, long population) {
        SrNo = srNo;
        this.countryName = countryName;
        this.countryIMG = countryIMG;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.newRecovered = newRecovered;
        this.activeCases = activeCases;
        this.seriousCases = seriousCases;
        this.totalTests = totalTests;
        this.population = population;
    }

    public long getSrNo() {
        return this.SrNo;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getCountryIMG() {
        return this.countryIMG;
    }

    public long getTotalCases() {
        return this.totalCases;
    }

    public long getNewCases() {
        return this.newCases;
    }

    public long getTotalDeaths() {
        return this.totalDeaths;
    }

    public long getNewDeaths() {
        return this.newDeaths;
    }

    public long getTotalRecovered() {
        return this.totalRecovered;
    }

    public long getNewRecovered() {
        return this.newRecovered;
    }

    public long getActiveCases() {
        return this.activeCases;
    }

    public long getSeriousCases() {
        return this.seriousCases;
    }

    public long getTotalTests() {
        return this.totalTests;
    }

    public long getPopulation() {
        return this.population;
    }
}
