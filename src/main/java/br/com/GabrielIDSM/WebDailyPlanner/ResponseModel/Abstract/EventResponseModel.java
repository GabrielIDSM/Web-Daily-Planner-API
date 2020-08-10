package br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.Abstract;

import java.util.Date;

public abstract class EventResponseModel {
    
    private Integer Id;
    private String Title;
    private String Details;
    private Date DateOfTheDay;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public Date getDateOfTheDay() {
        return DateOfTheDay;
    }

    public void setDateOfTheDay(Date DateOfTheDay) {
        this.DateOfTheDay = DateOfTheDay;
    }
    
}
