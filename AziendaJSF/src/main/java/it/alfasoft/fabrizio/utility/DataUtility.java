package it.alfasoft.fabrizio.utility;

import java.text.*;
import java.util.*;

public class DataUtility {
	
	public static String dateToString(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(data);
		return date;
	}
		
	//Da String a util.Date
	public static Date stringToDate(String data) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(data);
		return date;
	}
	
	
	
	
	//Da Calendar a util.Date
    public static Date calendarToUtilDate(Calendar cal){
  	   	return  cal.getTime();
    }
    
    //Da util.Date a Calendar
    public static Calendar utilDateToCalendar(Date d){
    	Calendar cal = Calendar.getInstance();
    	cal.setTimeInMillis(d.getTime());
    	return cal;
    }
	
    //Da util.Date a sql.Date
	public static java.sql.Date utilDateToSqlDate(Date data){
		return new java.sql.Date(data.getTime());	
	}
	
    //Da sql.Date a util.Date
	public static Date sqlDateToUtilDate(java.sql.Date data){
		return new Date(data.getTime());	
	}	
	
	//Differenza tra Date
	public static long getDifferenzaGiorni(Date data1, Date data2){
		long diffMillisecond = data2.getTime()-data1.getTime();
		long diff = diffMillisecond/86400000;
		return diff;
	}
}