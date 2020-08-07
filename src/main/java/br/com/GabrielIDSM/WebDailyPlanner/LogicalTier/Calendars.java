package br.com.GabrielIDSM.WebDailyPlanner.LogicalTier;

import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.CalendaryResponseModel;
import java.util.Calendar;

public abstract class Calendars {

    public static CalendaryResponseModel defineFirstMonth() {
        CalendaryResponseModel pm = new CalendaryResponseModel();
        Calendar c = Calendar.getInstance();
        pm.setMonth(c.get(Calendar.MONTH));
        pm.setYear(c.get(Calendar.YEAR));
        pm.setDays(DayCounter(c));
        return pm;
    }
    
    public static CalendaryResponseModel defineNextMonth(Integer month, Integer year){
        CalendaryResponseModel pm = new CalendaryResponseModel();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        c.add(Calendar.MONTH, 1);
        pm.setMonth(c.get(Calendar.DAY_OF_MONTH));
        pm.setYear(c.get(Calendar.YEAR));
        pm.setDays(DayCounter(c));
        return pm;
    }
    
    public static CalendaryResponseModel definePreviousMonth(Integer month, Integer year){
        CalendaryResponseModel pm = new CalendaryResponseModel();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        c.add(Calendar.MONTH, -1);
        pm.setMonth(c.get(Calendar.DAY_OF_MONTH));
        pm.setYear(c.get(Calendar.YEAR));
        pm.setDays(DayCounter(c));
        return pm;
    }

    private static int DayCounter(Calendar c) {
        if (isLeapYear(c.get(Calendar.YEAR))) {
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

    private static boolean isLeapYear(int ano) {
        return ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0));
    }
}
