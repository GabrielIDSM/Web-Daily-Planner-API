package br.com.GabrielIDSM.WebDailyPlanner.RequestModel.Abstract;

import java.util.Date;

public abstract class EventRequestModel {
    
    private Integer ID;
    private String email;
    private String password;
    private String title;
    private String Details;
    private Date DateOfTheDay;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
