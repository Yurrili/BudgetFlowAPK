package com.uj.yuri.budgetflow.MActivity.ListViewAdapter;

/**
 * Created by Yuri on 2016-01-13.
 */
public class HeaderElement extends EntryElement {

    String StartTime;
    public HeaderElement(){
        super("");
    }

    public HeaderElement(EntryElement L){
        super("");
        StartTime = L.getStartTime();
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getAmountString() {
        return null;
    }

    @Override
    public String getStartTime() {
        return StartTime;
    }

    @Override
    public String getEndTime() {
        return "";
    }


    @Override
    public int getFrequency() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean whatAmI() {
        return false;
    }
}
