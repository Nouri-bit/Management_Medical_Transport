package net.dao;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import net.model.Patient;
import net.model.Seance;

public class ValidationSeance {
	
public int ajoutkilometrage(Seance A) throws ClassNotFoundException{
	int tab=0; 
	Class.forName("org.postgresql.Driver")	;
	try {
		Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
		
		String sqlll = "UPDATE public.seance\r\n"
				+ "	SET kmreel=?, duree=?  \r\n"
				+ "	 where idseance=?;";
	 
		PreparedStatement statement2=connection.prepareStatement(sqlll);
		statement2.setFloat(1,A.getKmreel());
		statement2.setFloat(2,A.getDuree());
		statement2.setFloat(3,A.getIdseance());
		statement2.executeUpdate();
		
	    System.out.println(statement2); 
		 String sql= "SELECT  o.idoperateur, addresse\r\n"
		 		+ "	FROM public.\"chauffeur \" ch, public.\"operateur\" o\r\n"
		 		+ "    where ch.nss=? and ch.idoperateur= o.idoperateur \r\n"
		 		+ "    ;";
		 String sql2="    SELECT  addresse, addresseh\r\n"
		 		+ "        FROM public.\"patient\"\r\n"
		 		+ "        where nss=? \r\n"
		 		+ "        ;";
			PreparedStatement statement=connection.prepareStatement(sql);
			PreparedStatement statement22=connection.prepareStatement(sql2);
			statement22.setLong(1,A.getIdpatient());
			statement.setLong(1,A.getIdchauffeur());
			ResultSet rs1 =statement.executeQuery();
			ResultSet rs11 =statement22.executeQuery();
			if(rs1.next() && rs11.next()) {
				String addrch= rs1.getString("addresse").replace(' ', '%');
				String addrpa= rs11.getString("addresse").replace(' ', '%');
				String addrpah= rs11.getString("addresseh").replace(' ', '%');
				System.out.println(rs1.getString("addresse"));
				System.out.println(rs11.getString("addresse"));
				System.out.println(rs11.getString("addresseh"));
				///////////////// @ chauffeur
	                    URL url = new URL("http://www.mapquestapi.com/geocoding/v1/address?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&location="+addrch);
                         System.out.println(url);
	                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	                    conn.setRequestMethod("GET");
	                    conn.connect();

	                    //Check if connect is made
	                    int responseCode = conn.getResponseCode();

	                    // 200 OK
	                  /*  if (responseCode != 200) {
	                        throw new RuntimeException("HttpResponseCode: " + responseCode);
	                    } else {*/

	                        StringBuilder informationString = new StringBuilder();
	                        Scanner scanner = new Scanner(url.openStream());

	                        while (scanner.hasNext()) {
	                            informationString.append(scanner.nextLine());
	                        }
	                        //Close the scanner
	                        scanner.close();

	                        //System.out.println(informationString);


	                        //JSON simple library Setup with Maven is used to convert strings to JSON
	                        JSONParser parse = new JSONParser();
	                        JSONObject dataObject = (JSONObject) parse.parse(String.valueOf(informationString));
	                        //JSONObject site = (JSONObject)(((JSONArray)dataObject.get(0)).get(0));
	                        //Get the first JSON object in the JSON array
	                        //((ArrayList) dataObject.get("results")).toArray();
	                        JSONObject c= (JSONObject) ((ArrayList) dataObject.get("results")).toArray()[0];
	                        JSONObject  d= (JSONObject) ((ArrayList) c.get("locations")).toArray()[0];
	                        JSONObject e = (JSONObject) d.get("displayLatLng");
	                        System.out.println(e.get("lng"));
	                        System.out.println(e.get("lat"));
	                        //////// @ patient 
	                        URL url3 = new URL("http://www.mapquestapi.com/geocoding/v1/address?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&location="+addrpa);

	                        HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
	                        conn3.setRequestMethod("GET");
	                        conn3.connect();
	                            StringBuilder informationString3 = new StringBuilder();
	                            Scanner scanner3 = new Scanner(url3.openStream());

	                            while (scanner3.hasNext()) {
	                                informationString3.append(scanner3.nextLine());
	                            }
	                            //Close the scanner
	                            scanner3.close();
	                            JSONParser parse3 = new JSONParser();
	                            JSONObject dataObject3 = (JSONObject) parse3.parse(String.valueOf(informationString3));
	                            JSONObject c3= (JSONObject) ((ArrayList) dataObject3.get("results")).toArray()[0];
	                            JSONObject  d3= (JSONObject) ((ArrayList) c3.get("locations")).toArray()[0];
	                            JSONObject e3 = (JSONObject) d3.get("displayLatLng");
	                            System.out.println(e3.get("lng"));
	                            System.out.println(e3.get("lat"));
	                    ////////////////////////////////// strcuture sanitaire ////////////////////////////////
	                            URL url33 = new URL("http://www.mapquestapi.com/geocoding/v1/address?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&location="+addrpah);

		                        HttpURLConnection conn33 = (HttpURLConnection) url33.openConnection();
		                        conn33.setRequestMethod("GET");
		                        conn33.connect();
		                            StringBuilder informationString33 = new StringBuilder();
		                            Scanner scanner33 = new Scanner(url33.openStream());

		                            while (scanner33.hasNext()) {
		                                informationString33.append(scanner33.nextLine());
		                            }
		                            //Close the scanner  33
		                            scanner33.close();
		                            JSONParser parse33 = new JSONParser();
		                            JSONObject dataObject33 = (JSONObject) parse33.parse(String.valueOf(informationString33));
		                            JSONObject c33= (JSONObject) ((ArrayList) dataObject33.get("results")).toArray()[0];
		                            JSONObject  d33= (JSONObject) ((ArrayList) c33.get("locations")).toArray()[0];
		                            JSONObject e33 = (JSONObject) d33.get("displayLatLng");
		                            System.out.println(e33.get("lng"));
		                            System.out.println(e33.get("lat"));
	                    ///////////////////////////////calcul de la distance //////////////////////////////////
	                            double pi = 3.1415/180;
	                            double dis1 =  6371*Math.acos(((Math.sin((Double) e3.get("lat")*pi))*(Math.sin((Double) e33.get("lat")*pi)))+ ((Math.cos(((Double) e3.get("lat"))*pi))*(Math.cos(((Double) e33.get("lat"))*pi))*(Math.cos(pi*(((Double) e3.get("lng"))-((Double) e33.get("lng")))))));
	                            double distance1 = 6371*Math.acos(((Math.sin((Double) e3.get("lat")*pi))*(Math.sin((Double) e.get("lat")*pi)))+ ((Math.cos(((Double) e3.get("lat"))*pi))*(Math.cos(((Double) e.get("lat"))*pi))*(Math.cos(pi*(((Double) e3.get("lng"))-((Double) e.get("lng"))))))) ;
	                           double distance = dis1+distance1;
	                           System.out.println(dis1);
	                           System.out.println(distance1);
	                            System.out.println(distance);
	                            ///////////////////////////////////////////////////////////
	                   if(((A.getKmreel()<distance) || (distance-A.getKmreel()<10.0)) && (distance-A.getKmreel() >=0.0)  ) {
	                	   String sqll = "UPDATE public.seance\r\n"
	               				+ "	SET etat='valide' \r\n"
	               				+ "	 where idseance=?;";
	                	   PreparedStatement statemen=connection.prepareStatement(sqll);
	               		statemen.setFloat(1,A.getIdseance());
	               		statemen.executeUpdate();
	               		
	               	    System.out.println(statemen); 
	                	   
	                   }
	                   
			}
			
	 }catch(Exception e){
			e.printStackTrace();
		};
	 
	return tab; 
}
//////////////////////////////////////////////////////////////
////////////////////////VALIDER //////////////////////////////
public int valider(Seance A) throws ClassNotFoundException{
	 int tab = 0; 
	Class.forName("org.postgresql.Driver")	;
	try {
		Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
		
		 String sql= "SELECT  o.idoperateur, addresse\r\n"
		 		+ "	FROM public.\"chauffeur \" ch, public.\"operateur\" o\r\n"
		 		+ "    where ch.nss=? and ch.idoperateur= o.idoperateur \r\n"
		 		+ "    ;";
		 String sql2="    SELECT  addresse\r\n"
		 		+ "        FROM public.\"patient\"\r\n"
		 		+ "        where nss=? \r\n"
		 		+ "        ;";
			PreparedStatement statement=connection.prepareStatement(sql);
			PreparedStatement statement22=connection.prepareStatement(sql2);
			statement22.setLong(1,A.getIdpatient());
			statement.setLong(1,A.getIdchauffeur());
			ResultSet rs1 =statement.executeQuery();
			ResultSet rs11 =statement22.executeQuery();
			if(rs1.next() && rs11.next()) {
				
	                	   String sqll = "UPDATE public.seance\r\n"
	               				+ "	SET etat='valide' \r\n"
	               				+ "	 where idseance=?;";
	                	   PreparedStatement statemen=connection.prepareStatement(sqll);
	               		statemen.setFloat(1,A.getIdseance());
	               		statemen.executeUpdate();
	               		
	               	    System.out.println(statemen); 
	                	   
	                   
	                   
			}
			
	 }catch(Exception e){
			e.printStackTrace();
		};
	 
	return tab; 
}
//////// DONNER DISTANCE /////////////////////////////////
public double donner_distance(Seance A) throws ClassNotFoundException{
	 double distance = 0; 
	Class.forName("org.postgresql.Driver")	;
	try {
		Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
		
		
		 String sql= "SELECT  o.idoperateur, addresse\r\n"
		 		+ "	FROM public.\"chauffeur \" ch, public.\"operateur\" o\r\n"
		 		+ "    where ch.nss=? and ch.idoperateur= o.idoperateur \r\n"
		 		+ "    ;";
		 String sql2="    SELECT  addresse, addresseh\r\n"
			 		+ "        FROM public.\"patient\"\r\n"
			 		+ "        where nss=? \r\n"
			 		+ "        ;";
			PreparedStatement statement=connection.prepareStatement(sql);
			PreparedStatement statement22=connection.prepareStatement(sql2);
			statement22.setLong(1,A.getIdpatient());
			statement.setLong(1,A.getIdchauffeur());
			ResultSet rs1 =statement.executeQuery();
			ResultSet rs11 =statement22.executeQuery();
			if(rs1.next() && rs11.next()) {
				String addrch= rs1.getString("addresse").replace(' ', '%');
				String addrpa= rs11.getString("addresse").replace(' ', '%');
				String addrpah= rs11.getString("addresseh").replace(' ', '%');
				System.out.println(rs1.getString("addresse"));
				System.out.println(rs11.getString("addresse"));
				System.out.println(rs11.getString("addresseh"));
				///////////////// @ chauffeur
	                    URL url = new URL("http://www.mapquestapi.com/geocoding/v1/address?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&location="+addrch);
                         System.out.println(url);
	                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	                    conn.setRequestMethod("GET");
	                    conn.connect();

	                    //Check if connect is made
	                    int responseCode = conn.getResponseCode();

	                    // 200 OK
	                  /*  if (responseCode != 200) {
	                        throw new RuntimeException("HttpResponseCode: " + responseCode);
	                    } else {*/

	                        StringBuilder informationString = new StringBuilder();
	                        Scanner scanner = new Scanner(url.openStream());

	                        while (scanner.hasNext()) {
	                            informationString.append(scanner.nextLine());
	                        }
	                        //Close the scanner
	                        scanner.close();

	                        //System.out.println(informationString);


	                        //JSON simple library Setup with Maven is used to convert strings to JSON
	                        JSONParser parse = new JSONParser();
	                        JSONObject dataObject = (JSONObject) parse.parse(String.valueOf(informationString));
	                        //JSONObject site = (JSONObject)(((JSONArray)dataObject.get(0)).get(0));
	                        //Get the first JSON object in the JSON array
	                        //((ArrayList) dataObject.get("results")).toArray();
	                        JSONObject c= (JSONObject) ((ArrayList) dataObject.get("results")).toArray()[0];
	                        JSONObject  d= (JSONObject) ((ArrayList) c.get("locations")).toArray()[0];
	                        JSONObject e = (JSONObject) d.get("displayLatLng");
	                        System.out.println(e.get("lng"));
	                        System.out.println(e.get("lat"));
	                        //////// @ patient 
	                        URL url3 = new URL("http://www.mapquestapi.com/geocoding/v1/address?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&location="+addrpa);

	                        HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
	                        conn3.setRequestMethod("GET");
	                        conn3.connect();
	                            StringBuilder informationString3 = new StringBuilder();
	                            Scanner scanner3 = new Scanner(url3.openStream());

	                            while (scanner3.hasNext()) {
	                                informationString3.append(scanner3.nextLine());
	                            }
	                            //Close the scanner
	                            scanner3.close();
	                            JSONParser parse3 = new JSONParser();
	                            JSONObject dataObject3 = (JSONObject) parse3.parse(String.valueOf(informationString3));
	                            JSONObject c3= (JSONObject) ((ArrayList) dataObject3.get("results")).toArray()[0];
	                            JSONObject  d3= (JSONObject) ((ArrayList) c3.get("locations")).toArray()[0];
	                            JSONObject e3 = (JSONObject) d3.get("displayLatLng");
	                            System.out.println(e3.get("lng"));
	                            System.out.println(e3.get("lat"));
	                    ////////////////////////////////// strcuture sanitaire ////////////////////////////////
	                            URL url33 = new URL("http://www.mapquestapi.com/geocoding/v1/address?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&location="+addrpah);

		                        HttpURLConnection conn33 = (HttpURLConnection) url33.openConnection();
		                        conn33.setRequestMethod("GET");
		                        conn33.connect();
		                            StringBuilder informationString33 = new StringBuilder();
		                            Scanner scanner33 = new Scanner(url33.openStream());

		                            while (scanner33.hasNext()) {
		                                informationString33.append(scanner33.nextLine());
		                            }
		                            //Close the scanner  33
		                            scanner33.close();
		                            JSONParser parse33 = new JSONParser();
		                            JSONObject dataObject33 = (JSONObject) parse33.parse(String.valueOf(informationString33));
		                            JSONObject c33= (JSONObject) ((ArrayList) dataObject33.get("results")).toArray()[0];
		                            JSONObject  d33= (JSONObject) ((ArrayList) c33.get("locations")).toArray()[0];
		                            JSONObject e33 = (JSONObject) d33.get("displayLatLng");
		                            System.out.println(e33.get("lng"));
		                            System.out.println(e33.get("lat"));
	                    ///////////////////////////////calcul de la distance //////////////////////////////////
	                            double pi = 3.1415/180;
	                            double dis1=0;
	                            if((A.isAttente())==true) {
	                            	 dis1 =  6371*Math.acos(((Math.sin((Double) e3.get("lat")*pi))*(Math.sin((Double) e33.get("lat")*pi)))+ ((Math.cos(((Double) e3.get("lat"))*pi))*(Math.cos(((Double) e33.get("lat"))*pi))*(Math.cos(pi*(((Double) e3.get("lng"))-((Double) e33.get("lng")))))));
	  	                             dis1=dis1*2;
	                            }
	                            else {
	                            	 dis1 =  6371*Math.acos(((Math.sin((Double) e3.get("lat")*pi))*(Math.sin((Double) e33.get("lat")*pi)))+ ((Math.cos(((Double) e3.get("lat"))*pi))*(Math.cos(((Double) e33.get("lat"))*pi))*(Math.cos(pi*(((Double) e3.get("lng"))-((Double) e33.get("lng")))))));
	  	              
	                            }
	                            double distance1 = 6371*Math.acos(((Math.sin((Double) e3.get("lat")*pi))*(Math.sin((Double) e.get("lat")*pi)))+ ((Math.cos(((Double) e3.get("lat"))*pi))*(Math.cos(((Double) e.get("lat"))*pi))*(Math.cos(pi*(((Double) e3.get("lng"))-((Double) e.get("lng"))))))) ;
	                           distance = dis1+distance1;
	                           System.out.println(dis1);
	                           System.out.println(distance1);
	                            System.out.println(distance);
	                            ///////////////////////////////////////////////////////////
	                  
	                	   
			}
			
	 }catch(Exception e){
			e.printStackTrace();
		};
	 
	return distance; 
}
public List<Seance> liste_seances_non_valid() throws ClassNotFoundException{
	ArrayList<Seance> users= new ArrayList<Seance>();

	String sql = "SELECT idseance, titre, type, attente, idpatient, tranche, kmreel, jour, idchauffeur, etat, date, duree\r\n"
			+ "	FROM public.seance\r\n"
			+ "    where etat='Non valide' and kmreel>0.0;"; 
	Class.forName("org.postgresql.Driver")	;
	try {
		Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
		PreparedStatement statement=connection.prepareStatement(sql);
		ResultSet t=statement.executeQuery();
		double distance =0;
		 while(t.next()) {
			// t.getResultList();
			Seance A= new Seance();
			A.settitre(t.getString("titre"));
			A.setIdchauffeur(t.getLong("idchauffeur"));
			A.setIdpatient(t.getLong("idpatient"));
		     A.setIdseance(t.getInt("idseance"));
			A.setType(t.getInt("type"));
			A.setDuree(Float.valueOf(t.getString("duree")));
			A.setAttente(t.getBoolean("attente"));
			distance= donner_distance(A);
			System.out.println(distance);
			int d = (int)distance;
			A.setDistance(d);
			A.setTranche(t.getInt("tranche"));
			A.setKmreel(t.getFloat("kmreel"));
			A.setJour(t.getString("jour"));
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
public List<Seance> liste_seances() throws ClassNotFoundException{
		
		ArrayList<Seance> users= new ArrayList<Seance>();
		
		String sql = "SELECT idseance, titre, type, attente, idpatient, tranche, kmreel, jour, idchauffeur, etat, date, duree\r\n"
				+ "	FROM public.seance;"; 
		Class.forName("org.postgresql.Driver")	;
		try {
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			ResultSet t=statement.executeQuery();
			double distance = 0; 
			 while(t.next()) {
				// t.getResultList();
				Seance A= new Seance();
				A.settitre(t.getString("titre"));
				A.setIdchauffeur(t.getLong("idchauffeur"));
				A.setIdpatient(t.getLong("idpatient"));
			     A.setIdseance(t.getInt("idseance"));
				A.setType(t.getInt("type"));
				A.setAttente(t.getBoolean("attente"));
				A.setDuree(Float.valueOf(t.getString("duree")));
				A.setTranche(t.getInt("tranche"));
				A.setKmreel(t.getFloat("kmreel"));
				A.setJour(t.getString("jour"));
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
