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

import net.dao.ValidationSeance;
import net.model.Seance;

/**
 * Servlet implementation class ValidManuelServlet
 */
@WebServlet("/ValidManuelServlet")
public class ValidManuelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    ValidationSeance S = new ValidationSeance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Seance> liste = new ArrayList<Seance>();
		try {
			
			liste= S.liste_seances_non_valid();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("products", liste);
		
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Valid_manuel.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletrequestuest requestuest, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long idpatient=Long.parseLong(request.getParameter("idpatient"));
		Long idchauffeur=Long.parseLong(request.getParameter("idchauffeur"));
		int idseance=Integer.parseInt(request.getParameter("idseance"));
		Seance ss = new Seance();
		ss.setIdpatient(idpatient);
		ss.setIdchauffeur(idchauffeur);
		ss.setIdseance(idseance);
		
		try {
			
			S.valider(ss);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
