package net.frog.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;


@Component("commonUtil")
public class CommonUtil {

	public String str_Rnd(){
		//output rnd str
		Random rnd =new Random();
		StringBuffer buf =new StringBuffer();
		/*
		  * ·£´ý ¹®ÀÚ¿­
		  * 
		*/
		for(int i=0;i<5;i++){
		    if(rnd.nextBoolean()){
		        buf.append((char)((int)(rnd.nextInt(26))+97));
		    }else{
		        buf.append((rnd.nextInt(10))); 
		    }
		}
		String return_Rnd = buf.toString();
		
		return return_Rnd;
	}
	public String str_Date(){
		//output now date
		Date today = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		
		String return_Date = formater.format(today).toString();
		return return_Date;
		
	}
	
}
