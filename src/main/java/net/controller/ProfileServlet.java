package net.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.Profile;
import net.model.Agent;
import net.model.Chauffeur;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   Profile P = new Profile();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			Chauffeur CC=new Chauffeur();
			try {
				Long code = Long.parseLong(request.getParameter("nss"));
				CC = P.profile_Agent(code);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		request.setAttribute("nom", CC.getNom());
		request.setAttribute("prenom", CC.getPrenom());
		request.setAttribute("nss", CC.getNss());
		request.setAttribute("mail", CC.getMail());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profil.jsp");
		dispatcher.forward(request, response);
	}


}
