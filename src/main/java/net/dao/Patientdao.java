package net.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.JSONString;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;
import net.model.Patient;
import net.model.Seance;
import java.util.Comparator;
public class Patientdao {
	public static  void Sort2DArrayBasedOnColumnNumber (double[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<double[]>() {
            @Override
            public int compare(double[] first, double[] second) {
               if(first[columnNumber-1] > second[columnNumber-1]) return 1;
               else return -1;
            }
        });
    }
	public static String getDayStringOld(Date date, Locale locale) {
	    DateFormat formatter = new SimpleDateFormat("EEEE", locale);
	    return formatter.format(date);
	}
	public int [] ajoutPatient(Patient patient, List <Seance> seance) throws ClassNotFoundException{
		String sql= "INSERT INTO public.patient(\r\n"
				+ "	nss, nom, prenom, addresse, addresseh)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?);";
		String sql2= "INSERT INTO public.seance(\r\n"
				+ "	titre, type, attente, idpatient, tranche, jour, idchauffeur, etat, date, duree)\r\n"
				+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		String sqql= "SELECT idoperateur,addresse\r\n"
				+ "	FROM public.operateur;";
	int [] tab = {0,0,0,0,0,0,0,0};
	double [][] distances= {{0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0},{0,0}, {0,0}, {0,0}, {0,0} };
	int k=0;
	boolean trouv=false; 
		Class.forName("org.postgresql.Driver");
		try{
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(2,patient.getNom());
			statement.setString(3,patient.getPrenom());
			statement.setString(4,patient.getAddresse());
			statement.setLong(1,patient.getNSS());
			statement.setString(5,patient.getAddresseh());
			System.out.println(statement);
			tab[0]=statement.executeUpdate();
			int i = 1;
			int l =1;
		
			for(Seance Sa : seance) {
				    PreparedStatement statement2=connection.prepareStatement(sql2);
					statement2.setString(1, " S�ance "+l); 
					l++;
					statement2.setInt(2,Sa.getType());
					statement2.setBoolean(3, Sa.isAttente());
					statement2.setInt(5,Sa.getTranche());
					statement2.setString(6,Sa.getJour());
					statement2.setString(8,"Non valide");
					statement2.setLong(4,patient.getNSS());
					statement2.setString(10,"0.0");
					String test = getDayStringOld(Sa.getDate() , new  Locale("fr"));
					System.out.println(test); 
					System.out.println(Sa.getJour()); 
					System.out.println(Sa.getJour().equals(test)); 
					if (Sa.getJour().equals(test)) {
						statement2.setString(9,""+Sa.getDate());
						System.out.println("cas parfait "); 
						System.out.println(!Sa.getJour().equals(test));
			        	System.out.println(Sa.getJour().equals(test)== false);
					}
					
					else {
						//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			        	Date dt = Sa.getDate();
						while(!Sa.getJour().equals(test)){
							Calendar c = Calendar.getInstance();
					        c.setTime(dt);
					        c.add(Calendar.DATE, 1);
					        dt = c.getTime();
						 test = getDayStringOld((Date)dt,  new  Locale("fr"));
						 System.out.println(test);
						 System.out.println(dt); 
						}
						statement2.setString(9,""+dt);}
						//statement2.setString(9,""+Sa.getDate());
					
					//Statement statementt2=connection.createStatement();
					String sqlbo= "SELECT nss numero FROM public.\"chauffeur \"\r\n"
							+ "				WHERE  type=? and nss not in \r\n"
							+ "				(SELECT numero FROM\r\n"
							+ "				(SELECT ch.nss numero, count(*) compte, s.tranche tr, s.jour j \r\n"
							+ "				FROM public.\"chauffeur \" ch, public.\"seance\" s , public.\"patient\" p \r\n"
							+ "				where s.jour=? and s.tranche =?  and ch.nss= s.idchauffeur and p.nss= s.idpatient \r\n"
							+ "				group by s.jour , s.tranche , ch.nss\r\n"
							+ "				order by count(*) , numero\r\n"
							+ "				)resultat\r\n"
							+ "				) \r\n"
							+ "				FETCH FIRST 1 ROWS ONLY	\r\n"
							+ "					;";
					String sql3= "SELECT j, tr, ty, numero, idd FROM\r\n"
							+ "							(SELECT ch.nss numero, count(*) compte, s.tranche tr, s.jour j, s.type ty , o.idoperateur idd \r\n"
							+ "							FROM public.\"chauffeur \" ch, public.\"seance\" s , public.\"patient\" p , public.\"operateur\" o\r\n"
							+ "							where s.jour=? and s.tranche =? and s.type=?  and ch.idoperateur=? and ch.nss= s.idchauffeur and p.nss= s.idpatient \r\n"
							+ "                             and o.idoperateur=ch.idoperateur \r\n"
							+ "							group by s.jour , s.tranche , ch.nss, s.type, o.idoperateur\r\n"
							+ "							having count(*) <2\r\n"
							+ "							order by count(*) , numero)\r\n"
							+ "							resultat\r\n"
							+ "							FETCH FIRST 1 ROWS ONLY	;"; 
					String sql33= "SELECT j, tr, ty, numero FROM\r\n"
							+ "							(SELECT ch.nss numero, count(*) compte, s.tranche tr, s.jour j, s.type ty  \r\n"
							+ "							FROM public.\"chauffeur \" ch, public.\"seance\" s , public.\"patient\" p\r\n"
							+ "							where s.jour=? and s.tranche =? and s.type=?  and ch.nss= s.idchauffeur and p.nss= s.idpatient \r\n"
							+ "                              \r\n"
							+ "							group by s.jour , s.tranche , ch.nss, s.type\r\n"
							+ "							having count(*) <2\r\n"
							+ "							order by count(*) , numero)\r\n"
							+ "							resultat\r\n"
							+ "							FETCH FIRST 1 ROWS ONLY	;"; 
					String sql4="SELECT nss numero FROM public.\"chauffeur \"\r\n"
							+ "				WHERE  type=? and idoperateur=? and nss not in \r\n"
							+ "				(SELECT numero FROM\r\n"
							+ "				(SELECT ch.nss numero, count(*) compte, s.tranche tr, s.jour j \r\n"
							+ "				FROM public.\"chauffeur \" ch, public.\"seance\" s , public.\"patient\" p , public.\"operateur\" o\r\n"
							+ "				where s.jour=? and s.tranche =? and o.idoperateur=ch.idoperateur and ch.nss= s.idchauffeur and p.nss= s.idpatient \r\n"
							+ "				group by s.jour , s.tranche , ch.nss\r\n"
							+ "				order by count(*) , numero\r\n"
							+ "				)resultat\r\n"
							+ "				) \r\n"
							+ "				FETCH FIRST 1 ROWS ONLY	\r\n"
							+ "					;";
					
					
					PreparedStatement preparedStatement1 = connection.prepareStatement(sql3);
					PreparedStatement preparedStatement2 = connection.prepareStatement(sql4);
					PreparedStatement preparedStatementt = connection.prepareStatement(sqql);
					preparedStatement1.setString(1, Sa.getJour());
					preparedStatement1.setInt(2, Sa.getTranche());
					preparedStatement1.setInt(3, Sa.getType());
					
					//System.out.println(sql3);
					preparedStatement2.setString(3, Sa.getJour());
					preparedStatement2.setInt(4, Sa.getTranche());
					preparedStatement2.setInt(1, Sa.getType());
					//System.out.println(sql4);
					ResultSet rss = preparedStatementt.executeQuery();
					while(rss.next()) {
				
						String strin = patient.getAddresse().replace(' ', '%');
						String  addr= rss.getString("addresse").replace(' ', '%');
					    URL url2 = new URL("http://www.mapquestapi.com/directions/v2/routematrix?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&from="+addr+"&to="+strin);
		                System.out.println(url2);
		                HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
		                System.out.println(conn2);
		                conn2.setRequestMethod("POST");
		                conn2.connect();

		                //Check if co	nnect is made
		                int responseCode2 = conn2.getResponseCode();

		               
		                    StringBuilder informationString2 = new StringBuilder();
		                    Scanner scanner2 = new Scanner(url2.openStream());

		                    while (scanner2.hasNext()) {
		                        informationString2.append(scanner2.nextLine());
		                    }
		                    //Close the scanner
		                    scanner2.close();
		                    JSONParser parse2 = new JSONParser();
		                    JSONObject dataObject2 = (JSONObject) parse2.parse(String.valueOf(informationString2));
		                   String X= (((ArrayList) dataObject2.get("distance")).toArray()[0]).toString();
		                   String Y = ((ArrayList) dataObject2.get("distance")).toArray()[1].toString();
		                    double XX =	 new Double(X);
		                    double YY =	 new Double(Y);
		                    distances[k][0]= Math.sqrt((XX*XX)+(YY*YY));
		                    distances[k][1]= rss.getInt("idoperateur");
		                    k++;
			               }
					       Sort2DArrayBasedOnColumnNumber(distances,1);
					       for (int ii = 0; ii < distances.length; ii++) {
					            for (int j = 0; j < distances[ii].length; j++)
					                System.out.print(distances[ii][j] + " ");
					                System.out.println();
					        }
							k=0;
							while(trouv==false) {
								System.out.println((int) distances[k][1]);
								preparedStatement1.setInt(4, (int) distances[k][1]);
								preparedStatement2.setInt(2,(int) distances[k][1]);
								ResultSet rs = preparedStatement1.executeQuery();
								ResultSet rs2 = preparedStatement2.executeQuery(); 
								if (k<(distances.length)){
									if (rs2.next() ){
										//// cas jdid mais tjr la distance est minimal 
										
											statement2.setInt(7, rs2.getInt("numero"));
											tab[i]=statement2.executeUpdate();
											trouv=true; 
										}
										////cas 9dim mais tjr la distance est minimal   
										else if(rs.next()) {
											
											statement2.setInt(7,rs.getInt("numero"));
											tab[i]=statement2.executeUpdate();
											trouv=true; 
										}
										
								
									k++;
								}
								else {
									// khas des requetes jded 
									// sans l'aspect distance voila !! 
									PreparedStatement preparedStatement11 = connection.prepareStatement(sql33);
									PreparedStatement preparedStatement14= connection.prepareStatement(sqlbo);
									preparedStatement14.setString(2, Sa.getJour());
									preparedStatement14.setInt(3, Sa.getTranche());
									preparedStatement14.setInt(1, Sa.getType());
									ResultSet rs14 = preparedStatement14.executeQuery();
									preparedStatement11.setString(1, Sa.getJour());
									preparedStatement11.setInt(2, Sa.getTranche());
									preparedStatement11.setInt(3, Sa.getType());
									ResultSet rs1 = preparedStatement11.executeQuery();
									if (rs14.next()) {
										statement2.setInt(7,rs14.getInt("numero"));
									}
									else if (rs1.next()) {
										statement2.setInt(7,rs1.getInt("numero"));
									}
									else {
										/// cas t3 makanch les chauffeurs 
										System.out.println("Le syst�me est satur�, tous les chauffeurs ont �t� affect�s ");
									}
								}
								 
								
							}
					
					System.out.println(statement2);
					
					i++;
					Sa=null;
					statement2=null;
					trouv=false;
					k=0; 
					for (int ii = 0; ii < distances.length; ii++) {
			            for (int j = 0; j < distances[ii].length; j++)
			               distances[ii][j]=0;
			               
			        }
					
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
