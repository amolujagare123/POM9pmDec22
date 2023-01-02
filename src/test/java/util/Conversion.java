package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCountry)
    {
        String convertedCountry="";

        switch (shortCountry)
        {
            case "IN" : convertedCountry ="India";break;
            case "BR" : convertedCountry ="Brazil";break;
            case "KH" : convertedCountry ="Cambodia";break;
            case "CA" : convertedCountry ="Canada";break;
            case "FR" : convertedCountry ="France";break;
        }

        return convertedCountry;

    }

    public static String getGender(String genderID)
    {
        String gender = "";

        switch (genderID)
        {
            case "0" : gender = "Male";break;
            case "1" : gender = "Female";break;
            case "2" : gender = "Other";break;
        }

        return  gender;
    }

    //Expected :08/23/1989 : → MM/dd/yyyy
    //Actual   :1989-08-23 : → yyyy-MM-dd ( DB )

    public static String convertDate(String dbDate) throws ParseException // yyyy-MM-dd
    {
       // String convertedDate = ""; // MM/dd/yyyy

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);

        return  new SimpleDateFormat("MM/dd/yyyy").format(date);
    }

}
