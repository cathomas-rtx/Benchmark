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

@WebServlet("/BenchmarkTest07305")
public class BenchmarkTest07305 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
		// FILE URIs are tricky because they are different between Mac and Windows because of lack of standardization.
		// Mac requires an extra slash for some reason.
		String startURIslashes = "";
        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        	startURIslashes = "/";
	        else startURIslashes = "//";

		try {
			java.net.URI fileURI = new java.net.URI("file", null, startURIslashes 
				+ org.owasp.webgoat.benchmark.helpers.Utils.testfileDir.replace('\\', java.io.File.separatorChar).replace(' ', '_') + bar, null, null);
			new java.io.File(fileURI);
		} catch (java.net.URISyntaxException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55513 = param; //assign
		StringBuilder b55513 = new StringBuilder(a55513);  // stick in stringbuilder
		b55513.append(" SafeStuff"); // append some safe content
		b55513.replace(b55513.length()-"Chars".length(),b55513.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55513 = new java.util.HashMap<String,Object>();
		map55513.put("key55513", b55513.toString()); // put in a collection
		String c55513 = (String)map55513.get("key55513"); // get it back out
		String d55513 = c55513.substring(0,c55513.length()-1); // extract most of it
		String e55513 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55513.getBytes() ) )); // B64 encode and decode it
		String f55513 = e55513.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g55513 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55513); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
