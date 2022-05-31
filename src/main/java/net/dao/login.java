package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.model.Agent;

public class login {

	public int login_agent (Agent agent) throws ClassNotFoundException{
		int tab=0; 
String sql = "SELECT nss, pwd\r\n"
		+ "	FROM public.agent\r\n"
		+ "	where nss=? and pwd=? \r\n"
		+ "	;";
Class.forName("org.postgresql.Driver")	;
try {
	Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
	PreparedStatement statement=connection.prepareStatement(sql);
	statement.setInt(1,agent.getNss());
	statement.setString(2,agent.getPwd());
	System.out.println(sql);
	ResultSet t=statement.executeQuery();
	
	 if (t.next()) {
		 System.out.println("truuueee");
		 tab=5; 
	 }
	 else {
		 System.out.println("false");
		 tab=1;
	 }
	
}
catch(Exception e){
	e.printStackTrace();
};

return tab;
}
}
