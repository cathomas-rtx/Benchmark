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

@WebServlet("/BenchmarkTest02576")
public class BenchmarkTest02576 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a25816 = param; //assign
		StringBuilder b25816 = new StringBuilder(a25816);  // stick in stringbuilder
		b25816.append(" SafeStuff"); // append some safe content
		b25816.replace(b25816.length()-"Chars".length(),b25816.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25816 = new java.util.HashMap<String,Object>();
		map25816.put("key25816", b25816.toString()); // put in a collection
		String c25816 = (String)map25816.get("key25816"); // get it back out
		String d25816 = c25816.substring(0,c25816.length()-1); // extract most of it
		String e25816 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25816.getBytes() ) )); // B64 encode and decode it
		String f25816 = e25816.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g25816 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g25816); // reflection
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
