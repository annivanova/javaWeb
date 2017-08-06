package com.srk.pkg;

import java.sql.*;
import javax.swing.*;


public class MyConnection {
	Connection myConn=null;
	public static Connection dbConnectior(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:port", "", "");
			JOptionPane.showMessageDialog(null, "Connection established");
			return myConn;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	 

}
