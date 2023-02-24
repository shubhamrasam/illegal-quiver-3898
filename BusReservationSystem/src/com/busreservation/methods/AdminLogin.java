package com.busreservation.methods;

import java.util.Scanner;

import com.busreservation.colors.Colors;
import com.busreservation.dao.BusInfoDao;
import com.busreservation.dao.BusInfoDaoImpl;
import com.busreservation.exception.WrongCredentials;

public class AdminLogin {

	public static void adminLogin(Scanner sc) {
		 
		 BusInfoDao admin = new BusInfoDaoImpl();
		
		 System.out.println(Colors.BLACK_BOLD +"Please Enter your username" + Colors.RESET);
		 String username = sc.next();
		 System.out.println(Colors.BLACK_BOLD +"Please Enter your Password"+ Colors.RESET);
		 String password = sc.next();
		 
		 try {
			 
			 if(admin.loginAdmin(username, password)) {
				 
				 System.out.println(Colors.GREEN_BACKGROUND +" Welcome Admin " + Colors.RESET);
				 AdminDashboard.adminDashboard(sc);
				 
			 }
			 
		} catch (WrongCredentials e) {
			
			 System.out.println(Colors.RED_BACKGROUND +"Wrong Credentials" + Colors.RESET);
		}
		 
	}
	
}