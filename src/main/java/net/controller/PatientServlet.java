package net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.Patientdao;
import net.model.Patient;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PatientServlet() {
        // TODO Auto-generated constructor stub
    }
    Patientdao p = new Patientdao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Nom=request.getParameter("Nom");
		String Prenom=request.getParameter("Prenom");
		String Addresse=request.getParameter("Addresse");
		int idChauffeur=Integer.parseInt(request.getParameter("idChauffeur"));
	    int NSS= Integer.parseInt(request.getParameter("NSS"));
		Patient patient=new Patient();
		patient.setNom(Nom);
		patient.setPrenom(Prenom);
		patient.setAddresse(Addresse);
		patient.setIdChauffeur(idChauffeur);
		patient.setNSS(NSS);
		try {
			p.ajoutPatient(patient);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//doGet(request, response)
          response.sendRedirect("the page jsp ");
	}

}
