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

@WebServlet("/BenchmarkTest06372")
public class BenchmarkTest06372 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a49047 = param; //assign
		StringBuilder b49047 = new StringBuilder(a49047);  // stick in stringbuilder
		b49047.append(" SafeStuff"); // append some safe content
		b49047.replace(b49047.length()-"Chars".length(),b49047.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49047 = new java.util.HashMap<String,Object>();
		map49047.put("key49047", b49047.toString()); // put in a collection
		String c49047 = (String)map49047.get("key49047"); // get it back out
		String d49047 = c49047.substring(0,c49047.length()-1); // extract most of it
		String e49047 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49047.getBytes() ) )); // B64 encode and decode it
		String f49047 = e49047.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g49047 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g49047); // reflection
		
		
        try {
	    	java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
        	boolean randNumber = getNextNumber(numGen);
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Problem executing SecureRandom.nextBoolean() - TestCase");
            throw new ServletException(e);
        }

        response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextBoolean() executed");
	}
	
	boolean getNextNumber(java.util.Random generator) {
		return generator.nextBoolean();
	
	}
}
