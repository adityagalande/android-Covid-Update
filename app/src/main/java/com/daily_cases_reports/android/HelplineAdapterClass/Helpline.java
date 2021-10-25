package com.daily_cases_reports.android.HelplineAdapterClass;

public class Helpline {

    private String SR_NO, State_Name, Helpline_Number;

    public Helpline(String SR_NO, String State_Name, String Helpline_Number) {
        this.SR_NO = SR_NO;
        this.State_Name = State_Name;
        this.Helpline_Number = Helpline_Number;
    }

    public String getSR_NO() {
        return SR_NO;
    }

    public String getState_Name() {
        return State_Name;
    }

    public String getHelpline_Number() {
        return Helpline_Number;
    }
}
