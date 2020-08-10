package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Calendars;
import br.com.GabrielIDSM.WebDailyPlanner.Model.BirthdayModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.GenericModel;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.BirthdayRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.GenericRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("protected")
public class ProtectedController {
    
    final private GenericRepository GenericRepository;
    final private BirthdayRepository BirthdayRepository;
    final private UserRepository UserRepository;

    @Autowired
    public ProtectedController(GenericRepository G, BirthdayRepository B, UserRepository U) {
        this.GenericRepository = G;
        this.BirthdayRepository = B;
        this.UserRepository = U;
    }
    
    @PutMapping
    public ResponseEntity<?> DeleteOldEvents() {
        for(GenericModel g : (List<GenericModel>) GenericRepository.findAll()){
            if(Calendars.isEventOld(g.getDateOfTheDay())) GenericRepository.delete(g);
        }
        for(BirthdayModel b : (List<BirthdayModel>) BirthdayRepository.findAll()){
            if(Calendars.isEventOld(b.getDateOfTheDay())) BirthdayRepository.delete(b);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
