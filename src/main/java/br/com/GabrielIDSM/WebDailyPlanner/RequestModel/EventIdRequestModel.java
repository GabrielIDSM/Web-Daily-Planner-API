package br.com.GabrielIDSM.WebDailyPlanner.RequestModel;

public class EventIdRequestModel {

    private String Email;
    private String Password;
    private Integer Event;
    
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

    public Integer getEvent() {
        return Event;
    }

    public void setEvent(Integer Event) {
        this.Event = Event;
    }
    
}
