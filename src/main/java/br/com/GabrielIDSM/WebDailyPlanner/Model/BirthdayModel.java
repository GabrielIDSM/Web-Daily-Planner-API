package br.com.GabrielIDSM.WebDailyPlanner.Model;

import br.com.GabrielIDSM.WebDailyPlanner.Model.Abstract.EventModel;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WDP_Birthday")
public class BirthdayModel extends EventModel{
    
}
