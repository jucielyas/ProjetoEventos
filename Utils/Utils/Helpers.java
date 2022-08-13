package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helpers {

	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static String ToDateTimeFormatParse(Date data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		String result = formato.format(data).toString();
		return result;
	}
	public static String ToDateFormatParse(Date data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		String result = formato.format(data).toString();
		return result;
	}
}
