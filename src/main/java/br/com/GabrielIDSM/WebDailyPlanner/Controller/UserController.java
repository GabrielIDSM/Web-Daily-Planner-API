package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Users;
import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.IdRequestModel;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    
    final private UserRepository repository;
    
    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }
    
    @PostMapping
    public ResponseEntity<?> Save(@Valid @RequestBody UserModel user) {
        if (Users.isUserWithEncoder(user, (List<UserModel>) repository.findAll())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user = Users.newUser(user);
        repository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(path = "delete")
    public ResponseEntity<?> Delete(@Valid @RequestBody IdRequestModel user) {
        if (!Users.isUserWithEncoder(user, (List<UserModel>) repository.findAll())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserModel userModel = Users.getUser(user, (List<UserModel>) repository.findAll());
        repository.delete(userModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(path = "login")
    public ResponseEntity<?> isUser(@Valid @RequestBody IdRequestModel user) {
        if (Users.isUserWithEncoder(user, (List<UserModel>) repository.findAll())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}