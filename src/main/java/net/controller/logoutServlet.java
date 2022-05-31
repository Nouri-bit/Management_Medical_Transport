package net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet("/Login_servlet2")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
        
			request.getSession().invalidate();
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
    }

}
