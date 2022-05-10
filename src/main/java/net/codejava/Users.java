package net.codejava;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Users {

	public static void main(String[] args) {
		String jdbcUrl= "jdbc:postgresql://localhost:5433/2cs_project_18";
		String username="postgres";
		String password="20001999";
		// TODO Auto-generated method stub
		try {
			Connection connection= DriverManager.getConnection(jdbcUrl,username, password);
			System.out.println("C bon");
			String sql="INSERT INTO public.users(nom_utilisateur, mot_de_passe) VALUES ( 'boutheyna', 'test')";
			java.sql.Statement statement=connection.createStatement();
			int row=statement.executeUpdate(sql);
			if (row>0) 
			{
				System.out.println("great ^^ ");
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("mazaaal");
		}

	}

}
