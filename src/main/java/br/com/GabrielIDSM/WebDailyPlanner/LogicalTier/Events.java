package br.com.GabrielIDSM.WebDailyPlanner.LogicalTier;

import br.com.GabrielIDSM.WebDailyPlanner.Model.BirthdayModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.GenericModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.BirthdayRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.GenericRequestModel;
import java.util.List;

public abstract class Events {
    
    public final static int MAX = 10;
    
    public static BirthdayModel newBirthdayModel (BirthdayRequestModel request, List<UserModel> users){
        BirthdayModel response = new BirthdayModel();
        response.setID(request.getID());
        response.setTitle(request.getTitle());
        response.setDetails(request.getDetails());
        response.setDateOfTheDay(request.getDateOfTheDay());
        response.setUser(Users.getUser(request, users));
        return response;
    }
    
    public static GenericModel newGenericModel (GenericRequestModel request, List<UserModel> users){
        GenericModel response = new GenericModel();
        response.setID(request.getID());
        response.setTitle(request.getTitle());
        response.setDetails(request.getDetails());
        response.setDateOfTheDay(request.getDateOfTheDay());
        response.setUser(Users.getUser(request, users));
        return response;
    }
    
}
