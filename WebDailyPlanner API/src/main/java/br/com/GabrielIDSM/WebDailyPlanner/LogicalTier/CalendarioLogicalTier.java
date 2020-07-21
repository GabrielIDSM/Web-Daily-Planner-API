package br.com.GabrielIDSM.WebDailyPlanner.LogicalTier;

import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.CalendarioResponseModel;
import java.util.Calendar;

public abstract class CalendarioLogicalTier {

    public static CalendarioResponseModel DefinePrimeiroMes() {
        CalendarioResponseModel pm = new CalendarioResponseModel();
        Calendar c = Calendar.getInstance();
        pm.setMes(c.get(Calendar.MONTH));
        pm.setAno(c.get(Calendar.YEAR));
        pm.setnDeDias(NumeroDeDias(c));
        return pm;
    }
    
    public static CalendarioResponseModel DefineProximoMes(Integer mes, Integer ano){
        CalendarioResponseModel pm = new CalendarioResponseModel();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, mes);
        c.set(Calendar.YEAR, ano);
        c.add(Calendar.MONTH, 1);
        pm.setMes(c.get(Calendar.DAY_OF_MONTH));
        pm.setAno(c.get(Calendar.YEAR));
        pm.setnDeDias(NumeroDeDias(c));
        return pm;
    }
    
    public static CalendarioResponseModel DefineMesAnterior(Integer mes, Integer ano){
        CalendarioResponseModel pm = new CalendarioResponseModel();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, mes);
        c.set(Calendar.YEAR, ano);
        c.add(Calendar.MONTH, -1);
        pm.setMes(c.get(Calendar.DAY_OF_MONTH));
        pm.setAno(c.get(Calendar.YEAR));
        pm.setnDeDias(NumeroDeDias(c));
        return pm;
    }

    private static int NumeroDeDias(Calendar c) {
        if (ehBissexto(c.get(Calendar.YEAR))) {
            if (c.get(Calendar.MONTH) == 3
                    || c.get(Calendar.MONTH) == 5
                    || c.get(Calendar.MONTH) == 8
                    || c.get(Calendar.MONTH) == 10) {
                return 30;
            } else if (c.get(Calendar.MONTH) == 0
                    || c.get(Calendar.MONTH) == 2
                    || c.get(Calendar.MONTH) == 4
                    || c.get(Calendar.MONTH) == 6
                    || c.get(Calendar.MONTH) == 7
                    || c.get(Calendar.MONTH) == 9
                    || c.get(Calendar.MONTH) == 11) {
                return 31;
            } else {
                return 29;
            }
        } else {
            if (c.get(Calendar.MONTH) == 3
                    || c.get(Calendar.MONTH) == 5
                    || c.get(Calendar.MONTH) == 8
                    || c.get(Calendar.MONTH) == 10) {
                return 30;
            } else if (c.get(Calendar.MONTH) == 0
                    || c.get(Calendar.MONTH) == 2
                    || c.get(Calendar.MONTH) == 4
                    || c.get(Calendar.MONTH) == 6
                    || c.get(Calendar.MONTH) == 7
                    || c.get(Calendar.MONTH) == 9
                    || c.get(Calendar.MONTH) == 11) {
                return 31;
            } else {
                return 29;
            }
        }
    }

    private static boolean ehBissexto(int ano) {
        return ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0));
    }
}
