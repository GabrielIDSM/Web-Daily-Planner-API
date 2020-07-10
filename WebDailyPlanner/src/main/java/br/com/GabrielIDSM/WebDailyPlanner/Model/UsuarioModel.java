package br.com.GabrielIDSM.WebDailyPlanner.Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UsuarioModel implements Serializable{
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NotEmpty
    private String Nome;
    @NotEmpty
    private String Senha;
    
    //Construtor padrao

    public UsuarioModel(Integer Login, String Nome, String Senha) {
        this.ID = Login;
        this.Nome = Nome;
        this.Senha = Senha;
    }

    public UsuarioModel(String Nome, String Senha) {
        this.Nome = Nome;
        this.Senha = Senha;
    }
    
    public UsuarioModel() {
    }
    
    
    //Equals e hash

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioModel other = (UsuarioModel) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
    
    //Getters e Setters

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
}
