package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.model.Patient;
import net.model.Seance;

public class ValidationSeance {
public int ajoutkilometrage(Seance A) throws ClassNotFoundException{
	int tab=0; 
	Class.forName("org.postgresql.Driver")	;
	try {
		Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
		
		String sqlll = "UPDATE public.seance\r\n"
				+ "	SET kmreel=? \r\n"
				+ "	 where idseance=?;";
	 
		PreparedStatement statement2=connection.prepareStatement(sqlll);
		statement2.setFloat(1,A.getKmreel());
		statement2.setFloat(2,A.getIdseance());
		statement2.executeUpdate();
		
	    System.out.println(statement2); 
		 
	 }catch(Exception e){
			e.printStackTrace();
		};
	 
	return tab; 
}
public List<Seance> liste_seances() throws ClassNotFoundException{
		
		ArrayList<Seance> users= new ArrayList<Seance>();
		
		String sql = "SELECT idseance, titre, type, attente, idpatient, tranche, kmreel, jour, idchauffeur, etat, date\r\n"
				+ "	FROM public.seance;"; 
		Class.forName("org.postgresql.Driver")	;
		try {
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			ResultSet t=statement.executeQuery();
			
			 while(t.next()) {
				// t.getResultList();
				Seance A= new Seance();
				A.settitre(t.getString("titre"));
			     A.setIdseance(t.getInt("idseance"));
				A.setType(t.getInt("type"));
				A.setAttente(t.getBoolean("attente"));
				A.setIdpatient(t.getLong("idpatient"));
				A.setTranche(t.getInt("tranche"));
				A.setKmreel(t.getFloat("kmreel"));
				A.setJour(t.getString("jour"));
				A.setIdChauffeur(t.getLong("idchauffeur"));
				A.setEtat(t.getString("etat"));
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
				A.setDate(simpleDateFormat.parse(t.getString("date")));
				
				
				users.add(A);
				
			 }
			 
				
		}

		catch(Exception e){
			e.printStackTrace();
		};

		return users;
		
	}
 

}
