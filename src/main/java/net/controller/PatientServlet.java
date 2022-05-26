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
import net.dao.Patientdao;
import net.model.Patient;
import net.model.Seance;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/AjoutPatient")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private Patientdao p; 

    /**
     * Default constructor. 
     */
	
    /*public PatientServlet() {
        // TODO Auto-generated constructor stub
    }*/

    	Patientdao p = new Patientdao();
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AjoutPatient.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Nom=request.getParameter("nom");
		String Prenom=request.getParameter("prenom");
		String Addresse=request.getParameter("addresse");
		//int idChauffeur=Integer.parseInt(request.getParameter("idchauffeur"));
		int NSS= Integer.parseInt(request.getParameter("nss"));
		int type= Integer.parseInt(request.getParameter("type"));
		int tranche= Integer.parseInt(request.getParameter("tranche"));
		Boolean attente=Boolean.parseBoolean(request.getParameter("attente")); 
		//String titre=request.getParameter("titre");
		String [] jour=request.getParameterValues("jour");
		
		
		Patient patient=new Patient();	
		patient.setNom(Nom);
		patient.setPrenom(Prenom);
		patient.setAddresse(Addresse);
		//patient.setIdChauffeur(idChauffeur);
		patient.setNSS(NSS);
		List <Seance> sseance = new ArrayList<Seance>(); 
		int i = 0;
		//for (int i = 0; i<jour.length; i++) {
			while(   i< 4 && i<jour.length) {
			Seance seance = new Seance();
			//seance.settitre(titre);
			seance.setType(type);
			seance.setAttente(attente);
			seance.setTranche(tranche);
			seance.setJour(jour[i]);
			sseance.add(seance);
			//seance=null;
			i++;
		}
		//sseance.add(seance);
		
		try {
			p.ajoutPatient(patient, sseance);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Ajoutpatientdetails.jsp");
  		 dispatcher.forward(request, response);
  		  //response.sendRedirect("/WEB-INF/views/Ajoutpatientdetails.jsp");
  		  
}

}
