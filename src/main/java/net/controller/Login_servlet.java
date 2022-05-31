package net.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dao.login;
import net.model.Agent;

/**
 * Servlet implementation class Login_servlet
 */
@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	login p = new login();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nss=Integer.parseInt(request.getParameter("nss"));
		String pwd=request.getParameter("pwd");
		Agent agent = new Agent();
		agent.setNss(nss);
		agent.setPwd(pwd);
		System.out.println("heeeeeeeere ");
		try {
 			int tab= p.login_agent(agent);
 			if (tab==5)
 			{
 				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Ajoutpatient.jsp").dispatcher.forward(request, response);
 				request.getSession();
 				request.getRequestDispatcher("/WEB-INF/views/Ajoutpatient.jsp").forward(request, response);
 			}
 			else {
 				System.out.println("walouuu !! ");
 			}
 			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			}

}
