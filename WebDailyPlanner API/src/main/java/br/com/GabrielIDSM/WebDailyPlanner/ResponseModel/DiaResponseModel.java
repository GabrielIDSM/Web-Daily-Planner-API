package br.com.GabrielIDSM.WebDailyPlanner.ResponseModel;

import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoAniversarioModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoGenericoModel;
import java.io.Serializable;
import java.util.List;

public class DiaResponseModel implements Serializable{
    //Atributos
    
    List<EventoGenericoModel> EventosGenericos;
    List<EventoAniversarioModel> EventosAniversarios;
    
    //Getters e Setters

    public List<EventoGenericoModel> getEventosGenericos() {
        return EventosGenericos;
    }

    public void setEventosGenericos(List<EventoGenericoModel> EventosGenericos) {
        this.EventosGenericos = EventosGenericos;
    }

    public List<EventoAniversarioModel> getEventosAniversarios() {
        return EventosAniversarios;
    }

    public void setEventosAniversarios(List<EventoAniversarioModel> EventosAniversarios) {
        this.EventosAniversarios = EventosAniversarios;
    }
    
}
