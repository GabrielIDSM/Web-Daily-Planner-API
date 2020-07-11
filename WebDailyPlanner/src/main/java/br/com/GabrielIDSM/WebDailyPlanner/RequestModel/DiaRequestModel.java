package br.com.GabrielIDSM.WebDailyPlanner.RequestModel;

import java.io.Serializable;
import java.util.Date;

public class DiaRequestModel implements Serializable{
    //Atributos
    
    private Integer usuario;
    private Date dia;
    
    //Getters e Setters

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
    
}
