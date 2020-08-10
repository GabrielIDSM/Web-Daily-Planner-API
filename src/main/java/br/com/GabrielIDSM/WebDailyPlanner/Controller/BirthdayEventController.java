package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Events;
import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Users;
import br.com.GabrielIDSM.WebDailyPlanner.Model.BirthdayModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.EventIdRequestModel;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.BirthdayRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.UserRepository;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.BirthdayRequestModel;

@RestController
@RequestMapping("birthday")
public class BirthdayEventController {

    final private BirthdayRepository EventsRepository;
    final private UserRepository UsersRepository;

    @Autowired
    public BirthdayEventController(BirthdayRepository E, UserRepository U) {
        this.EventsRepository = E;
        this.UsersRepository = U;
    }

    @PostMapping
    public ResponseEntity<?> Save(@Valid @RequestBody BirthdayRequestModel request) {
        if (!Users.isUserWithEncoder(request, (List<UserModel>) UsersRepository.findAll())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<BirthdayModel> list = EventsRepository.findByUser(Users.getUser(request, (List<UserModel>) UsersRepository.findAll()));
        if(list.size() > Events.MAX) throw new ResourceNotFoundException("Limit reached");
        BirthdayModel event = Events.newBirthdayModel(request, (List<UserModel>) UsersRepository.findAll());
        EventsRepository.save(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> Update(@Valid @RequestBody BirthdayRequestModel request) {
        if (!Users.isUserWithEncoder(request, (List<UserModel>) UsersRepository.findAll())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BirthdayModel event = Events.newBirthdayModel(request, (List<UserModel>) UsersRepository.findAll());
        EventsRepository.save(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PostMapping(path = "delete")
    public ResponseEntity<?> Delete(@RequestBody EventIdRequestModel id) {
        if (!Users.isUserWithEncoder(id, (List<UserModel>) UsersRepository.findAll())) {
            throw new ResourceNotFoundException("User not found by id and password");
        }
        BirthdayModel event = EventsRepository.findOne(id.getEvent());
        if (event == null) {
            throw new ResourceNotFoundException("Event not found by id:" + id.getEvent());
        } else {
            EventsRepository.delete(event);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(path = "get")
    public ResponseEntity<?> getEventoByID(@RequestBody EventIdRequestModel id) {
        if (!Users.isUserWithEncoder(id, (List<UserModel>) UsersRepository.findAll())) {
            throw new ResourceNotFoundException("User not found by id and password");
        }
        BirthdayModel event = EventsRepository.findOne(id.getEvent());
        if (event == null) {
            throw new ResourceNotFoundException("Evento not found by id: " + id.getEvent());
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
