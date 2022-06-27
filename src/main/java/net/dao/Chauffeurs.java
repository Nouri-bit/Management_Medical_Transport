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

import net.model.Agent;
import net.model.Chauffeur;
import net.model.Seance;

public class Chauffeurs {
	public List<Chauffeur> Rembourssement() throws ClassNotFoundException{
	
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
				 ArrayList<Seance> ss= new ArrayList<Seance>();
				Chauffeur A= new Chauffeur();
				A.setMail(t.getString("mail"));
				A.setNom(t.getString("nom"));
				A.setNss(t.getLong("nss"));
				A.setPhoto(t.getString("photo"));
				A.setPrenom(t.getString("prenom"));
				A.setType(t.getInt("type"));
				A.setIdoperateur(t.getInt("idoperateur"));
				System.out.println(A.getNss());
				String sql2= "select dt, jr, kml, att, ty , tr from (select s.date dt ,s.jour jr,s.kmreel kml, s.attente att, s.type ty, s.tranche tr  from \r\n"
						+ "public.\"chauffeur \" ch , public.seance s  where ch.nss=? and s.idchauffeur = ch.nss and s.kmreel>0 and s.etat='valide' ) resultat ; "; 
				PreparedStatement statement2=connection.prepareStatement(sql2);
				statement2.setLong(1,A.getNss());
				ResultSet t2=statement2.executeQuery();
				while (t2.next()) {
					
					Seance seance = new Seance();
					seance.setJour(t2.getString("jr"));
					seance.setKmreel(t2.getFloat("kml"));
					seance.setAttente(t2.getBoolean("att"));
					seance.setType(t2.getInt("tr"));
					seance.setTranche(t2.getInt("ty"));
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
					seance.setDate(simpleDateFormat.parse(t2.getString("dt")));
					double montant =0;
					if(A.getType()==1) {
						if(seance.isAttente()==true) {
							
						}
						else {
							
						}
					}
					else if (A.getType()==2) {
						if(seance.isAttente()==true) {
							
						}
						else {
							
						}
					}
					else {
						if(seance.isAttente()==true) {
							
						}
						else {
							
						}
						
					}
					seance.setMontant(montant);
					ss.add(seance);
				}
				A.setSeance(ss);
				
				users.add(A);
			 }
			
		}

		catch(Exception e){
			e.printStackTrace();
		};
		return users;
	}
	//////////////////////////////////////// LISTE DES CHAUFFEURS /////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
				A.setNss(t.getLong("nss"));
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
