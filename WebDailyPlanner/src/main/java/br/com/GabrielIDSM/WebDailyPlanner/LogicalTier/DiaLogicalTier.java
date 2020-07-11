package br.com.GabrielIDSM.WebDailyPlanner.LogicalTier;

import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoAniversarioModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoGenericoModel;
import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.DiaResponseModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class DiaLogicalTier {
    public static DiaResponseModel DefineResponse(Date data, List<EventoGenericoModel> eg, List<EventoAniversarioModel> ea){
        DiaResponseModel responseModel = new DiaResponseModel();
        List<EventoGenericoModel> auxGenerico = new ArrayList<>();
        eg.stream().filter((e) -> (ComparaDatas(data, e.getDataDoDia()))).forEachOrdered((e) -> {
            auxGenerico.add(e);
        });
        responseModel.setEventosGenericos(auxGenerico);
        List<EventoAniversarioModel> auxAniversario = new ArrayList<>();
        ea.stream().filter((e) -> (ComparaDatas(data, e.getDataDoDia()))).forEachOrdered((e) -> {
            auxAniversario.add(e);
        });
        responseModel.setEventosAniversarios(auxAniversario);
        return responseModel;
    }
    public static boolean ComparaDatas(Date data1, Date data2){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(data1);
        c2.setTime(data2);
        return (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR));
    }
}
