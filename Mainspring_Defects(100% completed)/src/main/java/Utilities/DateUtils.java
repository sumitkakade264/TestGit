package Utilities;

import java.util.Date;

public class DateUtils {

	public static String getTimeStamp() {
		// TODO Auto-generated method stub
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}

}
