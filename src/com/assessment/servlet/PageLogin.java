package com.assessment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assessment.entity.*;

/**
 * Servlet implementation class PageLogin
 */
@WebServlet("/PageLogin")
public class PageLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		
		String username = request.getParameter("username");   
	    String password = request.getParameter("password");
	    if (username.equals("amruta")&&password.equals("ams@123")) {
	    	User user=new User();
	    	
	    	user.setUsername("amruta");
	    	user.setPassword("ams@123");
	    	HttpSession session=request.getSession();
	        session.setAttribute("username", username);
	        RequestDispatcher rd=request.getRequestDispatcher("mainmenu.jsp");
	        rd.forward(request, response);
	       
	    } else {
	    	request.setAttribute("message", "Invalid Username & Password, Please re-enter again");}
	    	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	        rd.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
	    }
		finally {
		            out.close();
	 	        } 
	
	}

	}


