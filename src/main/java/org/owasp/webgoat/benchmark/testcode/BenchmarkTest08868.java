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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08868")
public class BenchmarkTest08868 extends HttpServlet {
	
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

		String bar = new Test().doSomething(param);
		
        try {
	    	java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
        	boolean randNumber = numGen.nextBoolean();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Problem executing SecureRandom.nextBoolean() - TestCase");
            throw new ServletException(e);
        }

        response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextBoolean() executed");

	
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83710 = param; //assign
		StringBuilder b83710 = new StringBuilder(a83710);  // stick in stringbuilder
		b83710.append(" SafeStuff"); // append some safe content
		b83710.replace(b83710.length()-"Chars".length(),b83710.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83710 = new java.util.HashMap<String,Object>();
		map83710.put("key83710", b83710.toString()); // put in a collection
		String c83710 = (String)map83710.get("key83710"); // get it back out
		String d83710 = c83710.substring(0,c83710.length()-1); // extract most of it
		String e83710 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83710.getBytes() ) )); // B64 encode and decode it
		String f83710 = e83710.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83710); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
