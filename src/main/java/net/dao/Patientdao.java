package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import org.postgresql.*;
import net.model.Patient;
public class Patientdao {

	public int ajoutPatient(Patient patient) throws ClassNotFoundException{
		String sql= "INSERT INTO public.patient(\r\n"
				+ "	nss, nom, prenom, addresse, idchauffeur)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?);";
		int i=0;
		Class.forName("org.postgresql.Driver");
		try{
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(2,patient.getNom());
			statement.setString(3,patient.getPrenom());
			statement.setString(4,patient.getAddresse());
			statement.setInt(5,patient.getIdChauffeur());
			statement.setInt(1,patient.getNSS());
			System.out.println(statement);
			i=statement.executeUpdate();
			connection.close();
		}	
		catch(Exception e){
			e.printStackTrace();
		};
		
		return i;
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
