package database;

import java.sql.Connection;
import java.sql.DriverManager;

public  class ConnectionFactory {
	
	private static Connection con=null;

	private ConnectionFactory(){
	}

	public static  Connection getDbConnection() {
		if(con==null){
			try{
				Class.forName("com.mysql.jdbc.Driver");  
				con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/RECYCLER","root","MyNewPass");  
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return con;
	}
}
