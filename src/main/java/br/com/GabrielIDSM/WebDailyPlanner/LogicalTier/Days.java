package br.com.GabrielIDSM.WebDailyPlanner.LogicalTier;

import br.com.GabrielIDSM.WebDailyPlanner.Model.BirthdayModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.GenericModel;
import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.BirthdayResponseModel;
import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.DayResponseModel;
import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.GenericResponseModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Days {

    public static DayResponseModel DefineResponse(Date date, List<GenericModel> eg, List<BirthdayModel> ea) {
        DayResponseModel response = new DayResponseModel();
        List<GenericModel> genericList = new ArrayList<>();
        List<BirthdayModel> birthdayList = new ArrayList<>();

        eg.stream().filter((e) -> (isEqual(date, e.getDateOfTheDay()))).forEachOrdered((e) -> {
            genericList.add(e);
        });
        response.setGenericEvents(convertIntoGenericResponseModel(genericList));

        ea.stream().filter((e) -> (isEqual(date, e.getDateOfTheDay()))).forEachOrdered((e) -> {
            birthdayList.add(e);
        });
        response.setBirthdayEvents(convertIntoBirthdayResponseModel(birthdayList));
        return response;
    }

    private static boolean isEqual(Date data1, Date data2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(data1);
        c2.setTime(data2);
        return (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR));
    }

    public static List<GenericResponseModel> convertIntoGenericResponseModel(List<GenericModel> l) {
        List<GenericResponseModel> response = new ArrayList<>();
        for (GenericModel m : l) {
            GenericResponseModel rm = new GenericResponseModel();
            rm.setId(m.getID());
            rm.setTitle(m.getTitle());
            rm.setDetails(m.getDetails());
            rm.setDateOfTheDay(m.getDateOfTheDay());
            response.add(rm);
        }
        return response;
    }

    public static List<BirthdayResponseModel> convertIntoBirthdayResponseModel(List<BirthdayModel> l) {
        List<BirthdayResponseModel> response = new ArrayList<>();
        for (BirthdayModel m : l) {
            BirthdayResponseModel rm = new BirthdayResponseModel();
            rm.setId(m.getID());
            rm.setTitle(m.getTitle());
            rm.setDetails(m.getDetails());
            rm.setDateOfTheDay(m.getDateOfTheDay());
            response.add(rm);
        }
        return response;
    }

}