package method;

import java.util.Calendar;
import java.util.Date;

public class DateCalendar {

    public static Calendar DateToCalendar(Date date, boolean setTimeToZero){ 
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date);
        if(setTimeToZero){
            calendario.set(Calendar.HOUR_OF_DAY, 0);
            calendario.set(Calendar.MINUTE, 0);
            calendario.set(Calendar.SECOND, 0);
            calendario.set(Calendar.MILLISECOND, 0);
        }
        return calendario;
    }  
    
}
