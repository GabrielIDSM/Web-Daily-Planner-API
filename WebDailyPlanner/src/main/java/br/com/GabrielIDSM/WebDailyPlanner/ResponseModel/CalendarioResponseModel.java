package br.com.GabrielIDSM.WebDailyPlanner.ResponseModel;

public class CalendarioResponseModel {
    //Atributos
    
    private Integer mes;
    private Integer ano;
    private Integer nDeDias;
    
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

    public Integer getnDeDias() {
        return nDeDias;
    }

    public void setnDeDias(Integer nDeDias) {
        this.nDeDias = nDeDias;
    }
    
}
