package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.model.Agent;
import net.model.Chauffeur;

public class Profile {
public Chauffeur profile_Agent(Long nss) throws ClassNotFoundException{
		
		Chauffeur A = new Chauffeur();
		
		String sql = "SELECT nss, nom, prenom, mail, idoperateur, type, photo\r\n"
				+ "	FROM public.\"chauffeur \"\r\n"
				+ "    where nss=?;"; 
		Class.forName("org.postgresql.Driver")	;
		try {
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setFloat(1,nss);
			ResultSet t=statement.executeQuery();
			
			 if(t.next()) {
				
				
				A.setMail(t.getString("mail"));
				A.setNom(t.getString("nom"));
				A.setNss(t.getLong("nss"));
				A.setPrenom(t.getString("prenom"));
				
			 }
			
		}

		catch(Exception e){
			e.printStackTrace();
		};

		return A;
	}
}
