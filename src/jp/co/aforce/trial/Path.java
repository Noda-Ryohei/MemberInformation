package jp.co.aforce.trial;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/jsp/path"})
public class Path extends HttpServlet {

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//遷移元URL取得チャレンジ、死闘の跡
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
//		String method = request.getMethod();
//		String requestURI = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String servletPath = request.getServletPath();
//		String queryString = request.getQueryString();
//		String protocol = request.getProtocol();
//		String referer = request.getHeader("REFERER");
//		
//		System.out.println(method);
//		System.out.println(requestURI);
//		System.out.println(contextPath);
//		System.out.println(servletPath);
//		System.out.println(queryString);
//		System.out.println(protocol);
//		System.out.println(referer);
		
		System.out.println("Protocol: " + request.getProtocol());   
		System.out.println("Scheme: " + request.getScheme());   
		System.out.println("Server Name: " + request.getServerName() );   
		System.out.println("Server Port: " + request.getServerPort());   
		System.out.println("Protocol: " + request.getProtocol());   
		System.out.println("Server Info: " + getServletConfig().getServletContext().getServerInfo());   
		System.out.println("Remote Addr: " + request.getRemoteAddr());   
		System.out.println("Remote Host: " + request.getRemoteHost());   
		System.out.println("Character Encoding: " + request.getCharacterEncoding());   
		System.out.println("Content Length: " + request.getContentLength());   
		System.out.println("Content Type: "+ request.getContentType());   
		System.out.println("Auth Type: " + request.getAuthType());   
		System.out.println("HTTP Method: " + request.getMethod());   
		System.out.println("Path Info: " + request.getPathInfo());   
		System.out.println("Path Trans: " + request.getPathTranslated());   
		System.out.println("Query String: " + request.getQueryString());   
		System.out.println("Remote User: " + request.getRemoteUser());   
		System.out.println("Session Id: " + request.getRequestedSessionId());   
		System.out.println("Request URI: " + request.getRequestURI());   
		System.out.println("Servlet Path: " + request.getServletPath());   
		System.out.println("Accept: " + request.getHeader("Accept"));   
		System.out.println("Host: " + request.getHeader("Host"));   
		System.out.println("Referer : " + request.getHeader("Referer"));   
		System.out.println("Accept-Language : " + request.getHeader("Accept-Language"));   
		System.out.println("Accept-Encoding : " + request.getHeader("Accept-Encoding"));   
		System.out.println("User-Agent : " + request.getHeader("User-Agent"));   
		System.out.println("Connection : " + request.getHeader("Connection"));   
		System.out.println("Cookie : " + request.getHeader("Cookie"));   
		System.out.println("Created : " + session.getCreationTime());   
		System.out.println("LastAccessed : " + session.getLastAccessedTime()); 
		System.out.println("contextPath : " + request.getContextPath());
		System.out.println("http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + request.getServletPath());
		System.out.println("server name : " + request.getServerName());
		System.out.println("server port : " + request.getServerPort());
		System.out.println("context path : " + request.getContextPath());
		System.out.println("servlet path : " + request.getServletPath());

	}
	
}
