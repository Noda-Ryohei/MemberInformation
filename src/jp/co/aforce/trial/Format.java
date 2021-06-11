package jp.co.aforce.trial;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

	public static void main(String[] args) { 
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		System.out.println(format.format(date));
		
	}
}
