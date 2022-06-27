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

import net.dao.Chauffeurs;
import net.model.Chauffeur;

/**
 * Servlet implementation class RembourssementServlet
 */
@WebServlet("/RembourssementServlet")
public class RembourssementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Chauffeurs ch = new Chauffeurs();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				List<Chauffeur> liste = new ArrayList<Chauffeur>();
				try {
					
					liste= ch.liste_chauffeurs();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("products", liste);
				 
		        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/.jsp");
		        view.forward(request, response);
	}
}
