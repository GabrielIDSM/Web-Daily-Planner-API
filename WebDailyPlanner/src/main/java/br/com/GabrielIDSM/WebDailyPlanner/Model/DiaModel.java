package br.com.GabrielIDSM.WebDailyPlanner.Model;

import java.util.ArrayList;

public class DiaModel {
    //Atributos
    
    ArrayList<EventoGenericoModel> EventosGenericos;
    ArrayList<EventoAniversarioModel> EventosAniversarios;
    
    //Getters e Setters

    public ArrayList<EventoGenericoModel> getEventosGenericos() {
        return EventosGenericos;
    }

    public void setEventosGenericos(ArrayList<EventoGenericoModel> EventosGenericos) {
        this.EventosGenericos = EventosGenericos;
    }

    public ArrayList<EventoAniversarioModel> getEventosAniversarios() {
        return EventosAniversarios;
    }

    public void setEventosAniversarios(ArrayList<EventoAniversarioModel> EventosAniversarios) {
        this.EventosAniversarios = EventosAniversarios;
    }
    
}
