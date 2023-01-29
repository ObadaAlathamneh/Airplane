package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Services {
    public static Date convertStringToDate(String date) {
        try {
            if(date.contains(":"))
                return new SimpleDateFormat("yyyy/MM/dd/hh:mm:ss").parse(date);
            else
                return new SimpleDateFormat("yyyy/MM/dd").parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
