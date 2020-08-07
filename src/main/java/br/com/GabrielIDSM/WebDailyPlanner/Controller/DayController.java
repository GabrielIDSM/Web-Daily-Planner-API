package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Days;
import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Users;
import br.com.GabrielIDSM.WebDailyPlanner.Model.BirthdayModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.GenericModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.DayRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.IdRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.DayResponseModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.BirthdayRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.GenericRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.UserRepository;

@RestController
@RequestMapping("day")
public class DayController {

    final private GenericRepository GenericRepository;
    final private BirthdayRepository BirthdayRepository;
    final private UserRepository UserRepository;

    @Autowired
    public DayController(GenericRepository G, BirthdayRepository B, UserRepository U){
        this.GenericRepository = G;
        this.BirthdayRepository = B;
        this.UserRepository = U;
    }

    @PostMapping(path = "daybyuser")
    public ResponseEntity<?> getDayByUser (@RequestBody DayRequestModel dayRequest){
        if(!Users.isUserWithEncoder(dayRequest, (List<UserModel>) UserRepository.findAll())) throw new ResourceNotFoundException("Usuario not found by id and senha");
        List<GenericModel> genericList = GenericRepository.findByUser(Users.getUser(dayRequest, (List<UserModel>) UserRepository.findAll()));
        List<BirthdayModel> birthdayList = BirthdayRepository.findByUser(Users.getUser(dayRequest, (List<UserModel>) UserRepository.findAll()));
        return new ResponseEntity<>(Days.DefineResponse(dayRequest.getDay(), genericList, birthdayList), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> getAllByUser(@RequestBody IdRequestModel id){
        if(!Users.isUserWithEncoder(id, (List<UserModel>) UserRepository.findAll())) throw new ResourceNotFoundException("Usuario not found by id and senha");
        List<GenericModel> genericList = GenericRepository.findByUser(Users.getUser(id, (List<UserModel>) UserRepository.findAll()));
        List<BirthdayModel> birthdayList = BirthdayRepository.findByUser(Users.getUser(id, (List<UserModel>) UserRepository.findAll()));
        DayResponseModel dayResponse = new DayResponseModel();
        dayResponse.setGenericEvents(Days.convertIntoGenericResponseModel(genericList));
        dayResponse.setBirthdayEvents(Days.convertIntoBirthdayResponseModel(birthdayList));
        return new ResponseEntity<>(dayResponse, HttpStatus.OK);
    }
    
}
