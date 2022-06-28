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

import net.dao.Cartho;
import net.model.Chauffeur;
import net.model.Xy;

/**
 * Servlet implementation class Cartographie
 */
@WebServlet("/Cartographie")
public class Cartographie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Cartho ch = new Cartho();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Xy> liste = new ArrayList<Xy>();
		try {
			
			liste= ch.tracking();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("products", liste);
		 
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Cartographie.jsp");
        view.forward(request, response);
	}

	

}
