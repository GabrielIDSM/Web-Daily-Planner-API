package br.com.GabrielIDSM.WebDailyPlanner.RequestModel;

import java.io.Serializable;
import java.util.Date;

public class DiaRequestModel implements Serializable{
    //Atributos
    
    private Integer usuario;
    private String senha;
    private Date dia;
    
    //Getters e Setters

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
    
}
