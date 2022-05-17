package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import org.postgresql.*;
import net.model.Patient;
import net.model.Seance;
public class Patientdao {

	public int [] ajoutPatient(Patient patient, Seance seance) throws ClassNotFoundException{
		String sql= "INSERT INTO public.patient(\r\n"
				+ "	nss, nom, prenom, addresse)\r\n"
				+ "	VALUES (?, ?, ?, ?);";
		String sql2= "INSERT INTO public.seance(\r\n"
				+ "	titre, type, attente, idpatient, tranche, jour)\r\n"
				+ "	VALUES ( ?, ?, ?, ?, ?, ?);";
	int [] tab = {0,0};
		Class.forName("org.postgresql.Driver");
		try{
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(2,patient.getNom());
			statement.setString(3,patient.getPrenom());
			statement.setString(4,patient.getAddresse());
			//statement.setInt(5,patient.getIdChauffeur());
			statement.setInt(1,patient.getNSS());
			System.out.println(statement);
			tab[0]=statement.executeUpdate();
			PreparedStatement statement2=connection.prepareStatement(sql2);
			statement2.setString(1, "Patient_"+patient.getNom()+"_"+seance.gettitre());
			statement2.setInt(2,seance.getType());
			statement2.setBoolean(3, seance.isAttente());
			statement2.setInt(5,seance.getTranche());
			statement2.setInt(6,seance.getJour());
			statement2.setInt(4,patient.getNSS());
			System.out.println(statement2);
			tab[1]=statement2.executeUpdate();
			connection.close();
		}	
		catch(Exception e){
			e.printStackTrace();
		};
		
		return tab;
	}
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
