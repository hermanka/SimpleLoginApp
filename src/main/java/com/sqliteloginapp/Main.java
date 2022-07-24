/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqliteloginapp;

/**
 *
 * @author herma
 */
import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {			
		
            Connection c = null;                
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:accounts.db");
            c.setAutoCommit(false);

            Statement stmt = null;
            Scanner u = new Scanner(System.in);
            System.out.println("Enter username");
            String userName = u.nextLine();              
            Scanner p = new Scanner(System.in); 
            System.out.println("Enter password");
            String passWord = p.nextLine();        

            String query = "select * from user where username='" + userName + "' and password='" + passWord + "'";
            stmt = c.createStatement();

            ResultSet res = stmt.executeQuery(query);
            if(res.next()){
                System.out.println("Success login, welcome "+ userName);
            } else {
                System.out.println("Failed login");
            }
                
	}     
}