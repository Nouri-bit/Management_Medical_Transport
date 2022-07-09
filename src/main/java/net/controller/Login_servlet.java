package net.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.dao.login;
import net.model.Agent;
import net.model.Operateur;

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
		
		Long nss=Long.parseLong(request.getParameter("nss"));
		String pwd=request.getParameter("pwd");
		Agent agent = new Agent();
		Operateur agent2 = new Operateur();
		agent2.setIdoperateur(nss);
		agent2.setPwd(pwd);
		agent.setNss(nss);
		agent.setPwd(pwd);
		System.out.println("password and nss are correct!");
		try {
 			int tab= p.login_agent(agent);
 			int tab2= p.login_operateur(agent2);
 			System.out.println(tab);
 			System.out.println(tab2);
 			if (tab==5) 
 			{
 				
 				request.getSession();
 				HttpSession session = request.getSession();
 				request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
 				session.setAttribute("sessionUtilisateur", "adminstrator");
 	 			
 			}
 			else if (tab2==5) {
 				request.getSession();
 				HttpSession session = request.getSession();
 				request.getRequestDispatcher("/WEB-INF/views/dashboardOperateur.jsp").forward(request, response);
 				session.setAttribute("sessionUtilisateur", "adminstrator");
 			}
 			else {
 				
 				request.setAttribute("errorMessage", "Invalid Credentials!");
 	            request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
 			}
 			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			}

}
