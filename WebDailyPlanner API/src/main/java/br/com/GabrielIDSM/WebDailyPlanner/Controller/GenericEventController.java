package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Events;
import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Users;
import br.com.GabrielIDSM.WebDailyPlanner.Model.GenericModel;
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
import br.com.GabrielIDSM.WebDailyPlanner.Repository.GenericRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.UserRepository;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.GenericRequestModel;

@RestController
@RequestMapping("generic")
public class GenericEventController {

    final private GenericRepository EventRepository;
    final private UserRepository UsersRepository;

    @Autowired
    public GenericEventController(GenericRepository E, UserRepository U){
        this.EventRepository = E;
        this.UsersRepository = U;
    }

    @PostMapping
    public ResponseEntity<?> Save(@Valid @RequestBody GenericRequestModel request){
        GenericModel event = Events.newGenericModel(request, (List<UserModel>) UsersRepository.findAll());
        EventRepository.save(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> Update(@Valid @RequestBody GenericRequestModel request){
        GenericModel event = Events.newGenericModel(request, (List<UserModel>) UsersRepository.findAll());
        EventRepository.save(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<?> Delete(@RequestBody EventIdRequestModel id){
        if(!Users.isUserWithEncoder(id, (List<UserModel>) UsersRepository.findAll())) throw new ResourceNotFoundException("User not found by id and password");
        GenericModel evento = EventRepository.findOne(id.getEvent());
        if(evento == null){
            throw new ResourceNotFoundException("Event not found by id:" + id.getEvent());
        }else{
            EventRepository.delete(evento);
            return new ResponseEntity<>(evento, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/get")
    public ResponseEntity<?> getEventByID(@RequestBody EventIdRequestModel id){
        if(!Users.isUserWithEncoder(id, (List<UserModel>) UsersRepository.findAll())) throw new ResourceNotFoundException("User not found by id and password");
        GenericModel evento = EventRepository.findOne(id.getEvent());
        if(evento == null) throw new ResourceNotFoundException("Event not found by id: " + id.getEvent());
        else return new ResponseEntity<>(evento, HttpStatus.OK);
    }

}
