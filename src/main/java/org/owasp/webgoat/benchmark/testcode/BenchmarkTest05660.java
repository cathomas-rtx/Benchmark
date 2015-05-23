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

@WebServlet("/BenchmarkTest05660")
public class BenchmarkTest05660 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a94377 = param; //assign
		StringBuilder b94377 = new StringBuilder(a94377);  // stick in stringbuilder
		b94377.append(" SafeStuff"); // append some safe content
		b94377.replace(b94377.length()-"Chars".length(),b94377.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94377 = new java.util.HashMap<String,Object>();
		map94377.put("key94377", b94377.toString()); // put in a collection
		String c94377 = (String)map94377.get("key94377"); // get it back out
		String d94377 = c94377.substring(0,c94377.length()-1); // extract most of it
		String e94377 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94377.getBytes() ) )); // B64 encode and decode it
		String f94377 = e94377.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94377); // reflection
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
