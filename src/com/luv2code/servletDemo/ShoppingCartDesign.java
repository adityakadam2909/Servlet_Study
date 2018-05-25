package com.luv2code.servletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingCartDesign
 */
@WebServlet("/ShoppingCartDesign")
public class ShoppingCartDesign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartDesign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		String param1 = context.getInitParameter("max-set-value");
		String param2 = context.getInitParameter("project-team-name");
		
		out.println("<html><body>");
		out.println("<h2>"+"Shopping cart limit is "+param1+". "+"Project Team name is \""+param2+"\"." +"</h2>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
