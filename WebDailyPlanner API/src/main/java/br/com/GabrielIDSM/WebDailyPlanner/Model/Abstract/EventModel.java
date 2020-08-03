package br.com.GabrielIDSM.WebDailyPlanner.Model.Abstract;

import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EventModel implements Serializable{
    
    @Id
    Integer ID;
    @ManyToOne
    UserModel user;
    @NotEmpty
    String Details;
    @Temporal(TemporalType.DATE)
    Date DateOfTheDay;
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Descricao) {
        this.Details = Descricao;
    }

    public Date getDateOfTheDay() {
        return DateOfTheDay;
    }

    public void setDateOfTheDay(Date DateOfTheDay) {
        this.DateOfTheDay = DateOfTheDay;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel User) {
        this.user = User;
    }
    
}
