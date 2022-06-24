package net.dao;
import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.JSONString;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class App {
	public static String getDayStringOld(Date date, Locale locale) {
	    DateFormat formatter = new SimpleDateFormat("EEEE", locale);
	    return formatter.format(date);
	}
    public static void main(String[] args) {
        try {
        	/*******
        	 * donner X, y d'une @dresse 
        	 * 
        	 **********/
        	String tes = getDayStringOld(new Date(06-25-2022) , new  Locale("fr"));
        	System.out.println(new Date());
        	System.out.println(tes);
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        	Date dt = simpleDateFormat.parse("Fri Jun 24 09:48:58 UTC 2022");
        	Calendar cc = Calendar.getInstance();
	        cc.setTime(dt);
	        cc.add(Calendar.DATE, 1);
	        dt = cc.getTime();
	        System.out.println(dt);
           String queryy= "Washington DC Budget Office";
            URL url = new URL("http://www.mapquestapi.com/geocoding/v1/address?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&location=Washington%20DC%20Budget%20Office");

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
                /*******
            	 * Donner la distance entre deux @dresse 
            	 * 
            	 **********/
                String addr="Washington%Plaza%Hotel";
                String dis="Washington%DC%Budget%Office";
                URL url2 = new URL("http://www.mapquestapi.com/directions/v2/routematrix?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&from=Washington%Plaza%Hotel&to=Washington%Plaza%Hotel");
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
                    System.out.println(Math.sqrt((XX*XX)+(YY*YY)));
                    //System.out.println()
                    //JSONObject  dd= (JSONObject) ((ArrayList) dataObject2.get("d istance")).toArray()[0];
                    //System.out.println(dd);
                    
                   // JSONObject ee = (JSONObject) dataObject2.get("distance");
                   
            }
            
            catch (Exception e) {
            e.printStackTrace();
        }
    }

}