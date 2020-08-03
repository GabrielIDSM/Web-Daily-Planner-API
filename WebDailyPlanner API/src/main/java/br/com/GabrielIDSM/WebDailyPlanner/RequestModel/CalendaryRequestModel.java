package br.com.GabrielIDSM.WebDailyPlanner.RequestModel;

public class CalendaryRequestModel {
    
    private Integer Month; //0 - 11
    private Integer Year;

    public Integer getMonth() {
        return Month;
    }

    public void setMonth(Integer month) {
        this.Month = month;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer Year) {
        this.Year = Year;
    }

}
