package br.com.GabrielIDSM.WebDailyPlanner.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.dom4j.tree.AbstractEntity;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class AuthenticationModel extends AbstractEntity {
    //Atributos
    
    @Id
    private Integer Id;
    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private boolean acess;
    
    //Getters e Setters

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAcess() {
        return acess;
    }

    public void setAcess(boolean acess) {
        this.acess = acess;
    }
    
}
