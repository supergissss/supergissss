package com.wftech.common.check;
/**
 * @author ws
 *
 */
public class CheckDataUtils {
	
	public static boolean isEmail(String email){
		boolean tag = false;
		int at,dot;
		if(!email.equals("")&&email!=null){
			at = email.indexOf("@");
			dot = email.indexOf(".");
			if(at!=-1&&at!=0&&dot>at+1){
				tag = true;
			}
		}
		return tag;
	}
	
	public static boolean isPassword(String password){
		boolean tag = false;
		if(password!=null&&!password.equals("")){
			if(password.matches("[0-9a-zA-Z]*")&&password.length()>=6){
				tag = true;
			};
		}
		return tag;
	}
}
