/**
* OWASP WebGoat Benchmark Edition (WBE) v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* WebGoat Benchmark Edition (WBE) project. For details, please see
* <a href="https://www.owasp.org/index.php/WBE">https://www.owasp.org/index.php/WBE</a>.
*
* The WBE is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The WBE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15745")
public class BenchmarkTest15745 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a97062 = param; //assign
		StringBuilder b97062 = new StringBuilder(a97062);  // stick in stringbuilder
		b97062.append(" SafeStuff"); // append some safe content
		b97062.replace(b97062.length()-"Chars".length(),b97062.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97062 = new java.util.HashMap<String,Object>();
		map97062.put("key97062", b97062.toString()); // put in a collection
		String c97062 = (String)map97062.get("key97062"); // get it back out
		String d97062 = c97062.substring(0,c97062.length()-1); // extract most of it
		String e97062 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97062.getBytes() ) )); // B64 encode and decode it
		String f97062 = e97062.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g97062 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g97062); // reflection
	
		return bar;	
	}
}
