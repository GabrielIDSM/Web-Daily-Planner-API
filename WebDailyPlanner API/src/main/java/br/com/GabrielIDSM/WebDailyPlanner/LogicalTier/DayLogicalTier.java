package br.com.GabrielIDSM.WebDailyPlanner.LogicalTier;

import br.com.GabrielIDSM.WebDailyPlanner.Model.BirthdayModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.GenericModel;
import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.DayResponseModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class DayLogicalTier {
    
    public static DayResponseModel DefineResponse(Date data, List<GenericModel> eg, List<BirthdayModel> ea){
        DayResponseModel responseModel = new DayResponseModel();
        List<GenericModel> auxGenerico = new ArrayList<>();
        eg.stream().filter((e) -> (isEqual(data, e.getDateOfTheDay()))).forEachOrdered((e) -> {
            auxGenerico.add(e);
        });
        responseModel.setGenericEvents(auxGenerico);
        List<BirthdayModel> auxAniversario = new ArrayList<>();
        ea.stream().filter((e) -> (isEqual(data, e.getDateOfTheDay()))).forEachOrdered((e) -> {
            auxAniversario.add(e);
        });
        responseModel.setBirthdayEvents(auxAniversario);
        return responseModel;
    }
    public static boolean isEqual(Date data1, Date data2){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(data1);
        c2.setTime(data2);
        return (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR));
    }
}
