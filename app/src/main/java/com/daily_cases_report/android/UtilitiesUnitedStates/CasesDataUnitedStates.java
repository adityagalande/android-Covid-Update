package com.daily_update_of_covid_cases.android.UtilitiesUnitedStates;

public class CasesDataUnitedStates {

    private final String stateName;
    private final long totalCases;
    private final long newCases;
    private final long totalDeaths;
    private final long newDeaths;
    private final long totalRecovered;
    private final long activeCases;
    private final long totalTests;
    private final long population;


    public CasesDataUnitedStates(String stateName, long totalCases, long newCases, long totalDeaths, long newDeaths, long totalRecovered, long activeCases, long totalTests, long population) {

        this.stateName = stateName;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.activeCases = activeCases;
        this.totalTests = totalTests;
        this.population = population;
    }

    public String getStateName() {
        return this.stateName;
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

    public long getActiveCases() {
        return this.activeCases;
    }

    public long getTotalTests() {
        return this.totalTests;
    }

    public long getPopulation() {
        return this.population;
    }
}
