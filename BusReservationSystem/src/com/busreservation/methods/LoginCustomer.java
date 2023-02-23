package com.busreservation.methods;

import java.util.Scanner;

import com.busreservation.dao.CustomerDao;
import com.busreservation.dao.CustomerDaoImpl;
import com.busreservation.exception.SomeThingWentWrong;
import com.busreservation.exception.WrongCredentials;

public class LoginCustomer {

	public static void loginCustomer(Scanner sc) {

		 CustomerDao Customer = new CustomerDaoImpl();
		 
		 System.out.println("Please Enter your Email");
		 String email = sc.next();
		 System.out.println("Please Enter your Password");
		 String password = sc.next();
		 
	    try {
			Customer.customerLogin(email, password);
		} catch (SomeThingWentWrong | WrongCredentials e) {
			e.printStackTrace();
		}
		
	}

}