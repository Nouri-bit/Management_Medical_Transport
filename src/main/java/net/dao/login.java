package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import net.model.Agent;

public class login {
	private static Connection connection = null;
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
	System.out.println(agent.getNss() + " " + agent.getPwd());
	statement.setLong(1,agent.getNss());
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
	public static void closeConnection() {
		if (connection != null) {
            try {
            	connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
