package br.com.GabrielIDSM.WebDailyPlanner.RequestModel;

public class CalendarioRequestModel {
    //Atributos
    
    private Integer mes; //0 a 11
    private Integer ano;
    
    //Getters e Setters

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

}
