package br.com.GabrielIDSM.WebDailyPlanner.ResponseModel;

import java.io.Serializable;
import java.util.List;

public class DayResponseModel implements Serializable{

    List<GenericResponseModel> GenericEvents;
    List<BirthdayResponseModel> BirthdayEvents;

    public List<GenericResponseModel> getGenericEvents() {
        return GenericEvents;
    }

    public void setGenericEvents(List<GenericResponseModel> GenericEvents) {
        this.GenericEvents = GenericEvents;
    }

    public List<BirthdayResponseModel> getBirthdayEvents() {
        return BirthdayEvents;
    }

    public void setBirthdayEvents(List<BirthdayResponseModel> BirthdayEvents) {
        this.BirthdayEvents = BirthdayEvents;
    }
    
}
