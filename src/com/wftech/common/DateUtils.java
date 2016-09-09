package com.wftech.common;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author ws
 *
 */
public class DateUtils {
	public static Date getSqlDate(){
		return new Date(new java.util.Date().getTime());
	}
	
	public static String getTime(Timestamp time){
		String str = "";
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date now = new java.util.Date();
		long nowlong = now.getTime();
		long timelong = time.getTime();
		long distance = (nowlong-timelong)/1000;
		if(now.getMonth()!=time.getMonth()||now.getYear()!=time.getYear()){
			str = ft.format(time);
		}else if(now.getDay()-time.getDay()>=8){
			str = ft.format(time);
		}else if(now.getDay()!=time.getDay()){
			str = ""+(now.getDay()-time.getDay())+"天前";
		}else if(now.getHours()!=time.getHours()){
			str = ""+(now.getHours()-time.getHours())+"小时前";
		}else if(now.getMinutes()-time.getMinutes()>=30){
			str = "半小时前";
		}else if(distance>60){
			str = ""+distance/60+"分钟前";
		}else{
			str = ""+distance+"秒前";
		}
		return str;
	}
}
