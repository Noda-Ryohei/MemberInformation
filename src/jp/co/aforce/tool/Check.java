package jp.co.aforce.tool;

import javax.servlet.http.HttpServletRequest;

public class Check {
	
	public static boolean nullCheck (HttpServletRequest request) {
		
		String name = request.getParameter("name");
		if (name.length() == 0) {
			return false;
		}
		
		return true;
	}

}
