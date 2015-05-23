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

@WebServlet("/BenchmarkTest17015")
public class BenchmarkTest17015 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		String[] argsEnv = { bar };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a59427 = param; //assign
		StringBuilder b59427 = new StringBuilder(a59427);  // stick in stringbuilder
		b59427.append(" SafeStuff"); // append some safe content
		b59427.replace(b59427.length()-"Chars".length(),b59427.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59427 = new java.util.HashMap<String,Object>();
		map59427.put("key59427", b59427.toString()); // put in a collection
		String c59427 = (String)map59427.get("key59427"); // get it back out
		String d59427 = c59427.substring(0,c59427.length()-1); // extract most of it
		String e59427 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59427.getBytes() ) )); // B64 encode and decode it
		String f59427 = e59427.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g59427 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59427); // reflection
	
		return bar;	
	}
}
