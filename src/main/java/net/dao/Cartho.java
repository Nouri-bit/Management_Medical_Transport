package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.model.Chauffeur;
import net.model.Seance;
import net.model.Xy;

public class Cartho {
	
public List<Xy> tracking() throws ClassNotFoundException{
		
		ArrayList<Xy> users= new ArrayList<Xy>();
		
		
		String sql2="select pa, ns, x, y, adrh, idd from (select s.idpatient pa, ch.nss ns,x.x x, x.y y, p.addresseh adrh, x.idseance idd from public.\"chauffeur \" ch, public.seance s, public.xy x, public.patient p\r\n"
				+ "where s.idchauffeur=ch.nss and s.idseance=x.idseance and s.idpatient=p.nss) R ;";
		Class.forName("org.postgresql.Driver")	;
		try {
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql2);
			ResultSet t=statement.executeQuery();
			
			 while(t.next()) {
				// t.getResultList();
				Seance S= new Seance();
				S.setIdchauffeur(t.getLong("ns"));
				S.setIdpatient(t.getLong("pa"));
				S.setIdseance(t.getInt("idd"));
				Xy track = new Xy();
				track.setIdseance(S);
				track.setX(t.getFloat("x"));
				System.out.println(t.getFloat("x"));
				track.setY(t.getFloat("y"));
				System.out.println(t.getFloat("y"));
				track.setDistination(t.getString("adrh"));
				users.add(track);
			 }
			
		}

		catch(Exception e){
			e.printStackTrace();
		};

		return users;
	}
}
