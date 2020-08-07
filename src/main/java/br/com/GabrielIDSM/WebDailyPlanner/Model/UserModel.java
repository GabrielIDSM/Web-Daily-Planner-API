package br.com.GabrielIDSM.WebDailyPlanner.Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "WDP_Users")
public class UserModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(unique = true)
    private String Email;
    @NotEmpty
    private String Name;
    @NotEmpty
    private String Password;

    public UserModel(Integer ID, String Email, String Name, String Password) {
        this.ID = ID;
        this.Email = Email;
        this.Name = Name;
        this.Password = Password;
    }

    public UserModel(Integer Login, String Name, String Password) {
        this.ID = Login;
        this.Name = Name;
        this.Password = Password;
    }

    public UserModel(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }
    
    public UserModel() {
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
        final UserModel other = (UserModel) obj;
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

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
