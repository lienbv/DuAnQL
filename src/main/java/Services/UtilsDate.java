package Services;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UtilsDate {
	public void ngaydat(HttpServletRequest request) {
		Calendar c=Calendar.getInstance();
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		int day=c.get(Calendar.DATE);
		int month=c.get(Calendar.MONTH);
		int year=c.get(Calendar.YEAR);
		
		c.set(year, month, day);
		c1.set(year, month, day+1);
		c2.set(year, month, day+2);
		SimpleDateFormat fommat=new SimpleDateFormat("dd/MM/yyyy");
		String date1=fommat.format(c.getTime());
		String date2=fommat.format(c1.getTime());
		String date3=fommat.format(c2.getTime());
		request.setAttribute("ngay1", date1);
		request.setAttribute("ngay2", date2);
		request.setAttribute("ngay3", date3);
	}
	
	public void giodat(HttpServletRequest request, String date) {
		Calendar c=Calendar.getInstance();
		Calendar c3=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		SimpleDateFormat fommat=new SimpleDateFormat("dd/MM/yyyy");
		int day=c.get(Calendar.DATE);
		int month=c.get(Calendar.MONTH);
		int year=c.get(Calendar.YEAR);
		try {
			java.util.Date d=fommat.parse(date);
			c3.setTime(d);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int gio=c.get(Calendar.HOUR_OF_DAY);
		int phut=c.get(Calendar.MINUTE);
		String giodat=gio+":"+phut+":"+"00";
		Time t=Time.valueOf(giodat);
		String gio1="10:00:00",gio2="10:30:00",gio3="11:00:00",gio4="11:30:00",gio5="12:00:00",gio6="12:30:00",gio7="13:00:00",gio8="13:30:00",gio9="14:00:00",
				gio10="14:30:00",gio11="15:00:00",gio12="17:00:00",gio13="17:30:00",gio14="18:00:00",gio15="18:30:00",gio16="19:00:00",gio17="19:30:00",
				gio18="20:00:00",gio19="20:30:00",gio20="21:00:00",gio21="21:30:00",gio22="22:00:00",gio23="22:30:00",gio24="23:00:00";
		Time t1=Time.valueOf(gio1);
		Time t2=Time.valueOf(gio2);
		Time t3=Time.valueOf(gio3);
		Time t4=Time.valueOf(gio4);
		Time t5=Time.valueOf(gio5);
		Time t6=Time.valueOf(gio6);
		Time t7=Time.valueOf(gio7);
		Time t8=Time.valueOf(gio8);
		Time t9=Time.valueOf(gio9);
		Time t10=Time.valueOf(gio10);
		Time t11=Time.valueOf(gio11);
		Time t12=Time.valueOf(gio12);
		Time t13=Time.valueOf(gio13);
		Time t14=Time.valueOf(gio14);
		Time t15=Time.valueOf(gio15);
		Time t16=Time.valueOf(gio16);
		Time t17=Time.valueOf(gio17);
		Time t18=Time.valueOf(gio18);
		Time t19=Time.valueOf(gio19);
		Time t20=Time.valueOf(gio20);
		Time t21=Time.valueOf(gio21);
		Time t22=Time.valueOf(gio22);
		Time t23=Time.valueOf(gio23);
		Time t24=Time.valueOf(gio24);
		List<Time> giodatlich=new ArrayList<Time>();
		giodatlich.add(t1);
		giodatlich.add(t2);
		giodatlich.add(t3);
		giodatlich.add(t4);
		giodatlich.add(t5);
		giodatlich.add(t6);
		giodatlich.add(t7);
		giodatlich.add(t8);
		giodatlich.add(t9);
		giodatlich.add(t10);
		giodatlich.add(t11);
		giodatlich.add(t12);
		giodatlich.add(t13);
		giodatlich.add(t14);
		giodatlich.add(t15);
		giodatlich.add(t16);
		giodatlich.add(t17);
		giodatlich.add(t18);
		giodatlich.add(t19);
		giodatlich.add(t20);
		giodatlich.add(t21);
		giodatlich.add(t22);
		giodatlich.add(t23);
		giodatlich.add(t24);
		List<Time> hourbooking=new ArrayList<Time>();
		c2.set(year, month, day+1);
		String date1=fommat.format(c.getTime());
		int count=0;
		try {
			String date3=fommat.format(c2.getTime());
			java.util.Date d1=fommat.parse(date3);
			c2.setTime(d1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(c3.get(Calendar.DATE)==c.get(Calendar.DATE)) {
			count=1;
			for(Time x:giodatlich) {
				
				if(x.getHours()>t.getHours()) {
						hourbooking.add(x);
						
				}
			}
		}else if(c3.get(Calendar.DATE)==c2.get(Calendar.DATE)) {
			count=2;
			for(Time x:giodatlich) {
						hourbooking.add(x);
			}
		}else {
			count=3;
			for(Time x:giodatlich) {
						hourbooking.add(x);
			}
		}
		request.setAttribute("count", count);
		request.setAttribute("giodat", hourbooking);
	}
}
