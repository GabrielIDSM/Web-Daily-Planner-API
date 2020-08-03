package br.com.GabrielIDSM.WebDailyPlanner.ResponseModel;

import br.com.GabrielIDSM.WebDailyPlanner.Model.BirthdayModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.GenericModel;
import java.io.Serializable;
import java.util.List;

public class DayResponseModel implements Serializable{

    List<GenericModel> GenericEvents;
    List<BirthdayModel> BirthdayEvents;

    public List<GenericModel> getGenericEvents() {
        return GenericEvents;
    }

    public void setGenericEvents(List<GenericModel> GenericEvents) {
        this.GenericEvents = GenericEvents;
    }

    public List<BirthdayModel> getBirthdayEvents() {
        return BirthdayEvents;
    }

    public void setBirthdayEvents(List<BirthdayModel> BirthdayEvents) {
        this.BirthdayEvents = BirthdayEvents;
    }
    
}
