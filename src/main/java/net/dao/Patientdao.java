package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.text.html.HTMLDocument.Iterator;
import java.sql.*;
import org.postgresql.*;
import net.model.Patient;
import net.model.Seance;
public class Patientdao {

	public int [] ajoutPatient(Patient patient, List <Seance> seance) throws ClassNotFoundException{
		String sql= "INSERT INTO public.patient(\r\n"
				+ "	nss, nom, prenom, addresse)\r\n"
				+ "	VALUES (?, ?, ?, ?);";
		String sql2= "INSERT INTO public.seance(\r\n"
				+ "	titre, type, attente, idpatient, tranche, jour, idchauffeur)\r\n"
				+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?);";
		
		
	int [] tab = {0,0,0,0,0,0,0,0};
		Class.forName("org.postgresql.Driver");
		try{
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(2,patient.getNom());
			statement.setString(3,patient.getPrenom());
			statement.setString(4,patient.getAddresse());
			statement.setInt(1,patient.getNSS());
			System.out.println(statement);
			tab[0]=statement.executeUpdate();
			int i = 1;
			
		
			for(Seance Sa : seance) {
				    PreparedStatement statement2=connection.prepareStatement(sql2);
					statement2.setString(1, " Le Patient_"+patient.getNom()+"_"+patient.getPrenom()+"_"+patient.getNSS());
					statement2.setInt(2,Sa.getType());
					statement2.setBoolean(3, Sa.isAttente());
					statement2.setInt(5,Sa.getTranche());
					statement2.setString(6,Sa.getJour());
					statement2.setInt(4,patient.getNSS());
					//Statement statementt2=connection.createStatement();
					String sql3= "SELECT j, tr, ty, numero FROM\r\n"
							+ "(SELECT ch.nss numero, count(*) compte, s.tranche tr, s.jour j, s.type ty \r\n"
							+ "	FROM public.\"chauffeur \" ch, public.\"seance\" s , public.\"patient\" p \r\n"
							+ "	where s.jour=? and s.tranche =? and s.type=?  and ch.nss= s.idchauffeur and p.nss= s.idpatient \r\n"
							+ "	group by s.jour , s.tranche , ch.nss, s.type\r\n"
							+ "    having count(*) <2\r\n"
							+ "	order by count(*) , numero\r\n"
							+ ") resultat\r\n"
							+ "FETCH FIRST 1 ROWS ONLY	\r\n"
							+ "	;"; 
					String sql4="SELECT nss numero FROM public.\"chauffeur \"\r\n"
							+ "				WHERE  type=? and nss not in \r\n"
							+ "				(SELECT numero FROM\r\n"
							+ "				(SELECT ch.nss numero, count(*) compte, s.tranche tr, s.jour j \r\n"
							+ "				FROM public.\"chauffeur \" ch, public.\"seance\" s , public.\"patient\" p\r\n"
							+ "				where s.jour=? and s.tranche =? and ch.nss= s.idchauffeur and p.nss= s.idpatient \r\n"
							+ "				group by s.jour , s.tranche , ch.nss\r\n"
							+ "				order by count(*) , numero\r\n"
							+ "				)resultat\r\n"
							+ "				) \r\n"
							+ "				FETCH FIRST 1 ROWS ONLY	\r\n"
							+ "					;";
					
					PreparedStatement preparedStatement1 = connection.prepareStatement(sql3);
					PreparedStatement preparedStatement2 = connection.prepareStatement(sql4);
					preparedStatement1.setString(1, Sa.getJour());
					preparedStatement1.setInt(2, Sa.getTranche());
					preparedStatement1.setInt(3, Sa.getType());
					//System.out.println(sql3);
					preparedStatement2.setString(2, Sa.getJour());
					preparedStatement2.setInt(3, Sa.getTranche());
					preparedStatement2.setInt(1, Sa.getType());
					//System.out.println(sql4);
					ResultSet rs = preparedStatement1 .executeQuery();
					ResultSet rs2 = preparedStatement2.executeQuery();
					if (rs2.next()){
						statement2.setInt(7, rs2.getInt("numero"));
						tab[i]=statement2.executeUpdate();
					}
					
					else if(rs.next()) {
						statement2.setInt(7,rs.getInt("numero"));
						tab[i]=statement2.executeUpdate();
					}
					else {
						System.out.println("Le système est complet !! pas de chauffeurs suffisants pour ces patients ")		;		}
					
					System.out.println(statement2);
					
					i++;
					Sa=null;
					statement2=null;
					
			    }
			
			
			
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
