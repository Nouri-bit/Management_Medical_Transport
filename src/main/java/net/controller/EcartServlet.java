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
 * Servlet implementation class EcartServlet
 */
@WebServlet("/EcartServlet")
public class EcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ValidationSeance S = new ValidationSeance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Seance> liste = new ArrayList<Seance>();
		try {
			liste= S.liste_seances_tous();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("products", liste);
		
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/.jsp");
        view.forward(request, response);
	}

}
