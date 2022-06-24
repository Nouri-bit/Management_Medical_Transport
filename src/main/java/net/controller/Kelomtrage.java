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
 * Servlet implementation class Kelomtrage
 */
@WebServlet("/Kelomtrage")
public class Kelomtrage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ValidationSeance S = new ValidationSeance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Seance> liste = new ArrayList<Seance>();
		try {
			liste= S.liste_seances();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("products", liste);
		
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/AjoutKm.jsp");
        view.forward(request, response);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.service(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Float kmreel=Float.parseFloat(req.getParameter("kmreel"));
		int idseance=Integer.parseInt(req.getParameter("idseance"));
		Seance ss = new Seance();
		System.out.println(kmreel);
		System.out.println(idseance);
		ss.setKmreel(kmreel);
		ss.setIdseance(idseance);
		try {
			S.ajoutkilometrage(ss);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/AjoutKm.jsp");
       // view.forward(req, resp);
		doGet(req, resp);
	}

	
	
  
}
