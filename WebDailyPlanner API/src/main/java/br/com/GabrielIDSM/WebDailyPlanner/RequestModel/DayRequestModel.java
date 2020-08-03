package br.com.GabrielIDSM.WebDailyPlanner.RequestModel;

import java.io.Serializable;
import java.util.Date;

public class DayRequestModel implements Serializable{

    private String Email;
    private String Password;
    private Date Day;
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public Date getDay() {
        return Day;
    }

    public void setDay(Date Day) {
        this.Day = Day;
    }
    
}
