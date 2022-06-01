package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.model.Agent;
import net.model.Chauffeur;

public class Chauffeurs {
	
	public List<Chauffeur> liste_chauffeurs() throws ClassNotFoundException{
		
		ArrayList<Chauffeur> users= new ArrayList<Chauffeur>();
		
		String sql = "SELECT nss, nom, prenom, mail, idoperateur, type, photo\r\n"
				+ "	FROM public.\"chauffeur \";"; 
		Class.forName("org.postgresql.Driver")	;
		try {
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			ResultSet t=statement.executeQuery();
			
			 while(t.next()) {
				// t.getResultList();
				Chauffeur A= new Chauffeur();
				A.setMail(t.getString("mail"));
				A.setNom(t.getString("nom"));
				A.setNss(t.getInt("nss"));
				A.setPhoto(t.getString("photo"));
				A.setPrenom(t.getString("prenom"));
				A.setType(t.getInt("type"));
				A.setIdoperateur(t.getInt("idoperateur"));
				users.add(A);
			 }
			
		}

		catch(Exception e){
			e.printStackTrace();
		};

		return users;
	}
 
}
