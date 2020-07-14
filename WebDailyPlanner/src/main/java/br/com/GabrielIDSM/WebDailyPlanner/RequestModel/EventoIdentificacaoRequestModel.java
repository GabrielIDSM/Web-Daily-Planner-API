package br.com.GabrielIDSM.WebDailyPlanner.RequestModel;

public class EventoIdentificacaoRequestModel {
    //Atributos
    
    Integer id;
    String senha;
    Integer evento;
    
    //Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getEvento() {
        return evento;
    }

    public void setEvento(Integer evento) {
        this.evento = evento;
    }
    
}
