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

@WebServlet("/BenchmarkTest09240")
public class BenchmarkTest09240 extends HttpServlet {
	
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

		String bar = new Test().doSomething(param);
		
		try {
		    java.util.Properties wbeprops = new java.util.Properties();
		    wbeprops.load(this.getClass().getClassLoader().getResourceAsStream("wbe.properties"));
			String algorithm = wbeprops.getProperty("hashAlg1", "SHA512");
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a49592 = param; //assign
		StringBuilder b49592 = new StringBuilder(a49592);  // stick in stringbuilder
		b49592.append(" SafeStuff"); // append some safe content
		b49592.replace(b49592.length()-"Chars".length(),b49592.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49592 = new java.util.HashMap<String,Object>();
		map49592.put("key49592", b49592.toString()); // put in a collection
		String c49592 = (String)map49592.get("key49592"); // get it back out
		String d49592 = c49592.substring(0,c49592.length()-1); // extract most of it
		String e49592 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49592.getBytes() ) )); // B64 encode and decode it
		String f49592 = e49592.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g49592 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g49592); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
