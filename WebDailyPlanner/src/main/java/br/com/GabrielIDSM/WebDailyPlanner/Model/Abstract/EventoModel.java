package br.com.GabrielIDSM.WebDailyPlanner.Model.Abstract;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EventoModel implements Serializable{
    //Atributos
    
    @Id
    Integer ID;
    @NotEmpty
    Integer usuario;
    String descricao;
    @Temporal(TemporalType.DATE)
    Date dataDoDia;
    
    //Getters e Setters

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String Descricao) {
        this.descricao = Descricao;
    }

    public Date getDataDoDia() {
        return dataDoDia;
    }

    public void setDataDoDia(Date dataDoDia) {
        this.dataDoDia = dataDoDia;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
    
}
