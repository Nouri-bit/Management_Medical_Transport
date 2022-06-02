package net.dao;
import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.JSONString;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
        	/*******
        	 * donner X, y d'une @dresse 
        	 * 
        	 **********/
           String queryy= "Washington,DC";
            URL url = new URL("https://www.mapquestapi.com/geocoding/v1/address?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&location="+queryy);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);


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
                String addr="Washington,DC";
                String dis="Westminster,CO";
                URL url2 = new URL("http://www.mapquestapi.com/directions/v2/routematrix?key=5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9&from=Denver,%20CO&to=Westminster,%20CO");
                System.out.println(url2);
                HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
                System.out.println(conn2);
                conn2.setRequestMethod("POST");
                conn2.connect();

                //Check if co	nnect is made
                int responseCode2 = conn2.getResponseCode();

                // 200 OK
                if (responseCode2 != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responseCode2);
                } else {

                    StringBuilder informationString2 = new StringBuilder();
                    Scanner scanner2 = new Scanner(url2.openStream());

                    while (scanner2.hasNext()) {
                        informationString2.append(scanner2.nextLine());
                    }
                    //Close the scanner
                    scanner2.close();
                    System.out.println(informationString2);
            }
            
            }} catch (Exception e) {
            e.printStackTrace();
        }
    }

}