package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import net.model.Patient;

public class Patientdao {

	public int ajoutPatient(Patient patient) throws ClassNotFoundException{
		String sql= "INSERT INTO public.'Patient'('Nom', 'Prenom', 'Addresse', 'idChauffeur', 'NSS') VALUES (?, ?, ?, ?, ?);";
		int i=0;
		Class.forName("org.postgresql.Driver");
		try{
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1,patient.getNom());
			statement.setString(2,patient.getPrenom());
			statement.setString(3,patient.getAddresse());
			statement.setInt(4,patient.getIdChauffeur());
			statement.setInt(5,patient.getNSS());
			System.out.println(statement);
			i=statement.executeUpdate();
		}	
		catch(Exception e){
			e.printStackTrace();
		};
		
		return i;
	}
}
