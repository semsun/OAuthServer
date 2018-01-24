package com.masget.oauth.profit.masget.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.masget.oauth.core.entity.Client;

@WebServlet(name="login", urlPatterns="/oauth2login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5636696535255430720L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = (Client) request.getAttribute("client");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println( String.format("<h1>welcome this is my servlet!!! %s</h1>", client.getClientName()) );
        out.println("</body>");
        out.println("</html>");
		
//		super.service(request, response);
	}

	
}
