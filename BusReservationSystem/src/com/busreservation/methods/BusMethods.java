package com.busreservation.methods;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.busreservation.colors.Colors;
import com.busreservation.dao.BusInfoDao;
import com.busreservation.dao.BusInfoDaoImpl;
import com.busreservation.dto.BusInfo;
import com.busreservation.dto.BusInfoImpl;
import com.busreservation.exception.SomeThingWentWrong;

public class BusMethods {

	public static void addBus(Scanner sc) {
		
		BusInfoDao busInfo = new BusInfoDaoImpl();
		
		System.out.println("Enter Bus Number");
		int busNo = sc.nextInt();
		System.out.println("Enter Bus Type (AC/Non-AC)");
		String busType = sc.next();
		System.out.println("Enter Departure from");
		String departure = sc.next();
		System.out.println("Enter Destination");
		String destination = sc.next();
		System.out.println("Enter Bus Total Seats");
		int total_seats = sc.nextInt();
		System.out.println("Enter Bus Booked Seats");
		int booked_seats = sc.nextInt();
		System.out.println("Enter Bus Avaliable Seats");
		int avaliable_seats = sc.nextInt();
		System.out.println("Enter Depature Date and Time");
		LocalDateTime depDate = LocalDateTime.parse(sc.next());
		System.out.println("Enter Destination Arrival Date and Time");
		LocalDateTime arrDate = LocalDateTime.parse(sc.next());
		System.out.println("Enter Bus Fare");
		int fare = sc.nextInt();
		
		BusInfo bus = new BusInfoImpl(busNo,busType, departure , destination ,total_seats ,booked_seats,avaliable_seats,depDate,arrDate,fare);
	    
		try {
			System.out.println(busInfo.addBus(bus));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			AdminDashboard.adminDashboard(sc);
		} catch (SomeThingWentWrong e) {
			e.printStackTrace();
			AdminDashboard.adminDashboard(sc);
		}
		
	}
	
	
	public static void removeBus(Scanner sc) {
		
		BusInfoDao busInfo = new BusInfoDaoImpl();
		
		System.out.println("Enter Bus Number");
		int BusNumber = sc.nextInt();
		
		try {
			if(busInfo.removeBus(BusNumber)) {
				
				System.out.println(Colors.GREEN_BACKGROUND+" Bus removed"+Colors.RESET);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				AdminDashboard.adminDashboard(sc);
			}
			
		} catch (SomeThingWentWrong e) {
			e.printStackTrace();
			AdminDashboard.adminDashboard(sc);
		}
		
	}
	
	public static void changeBusDep(Scanner sc) {
		
		BusInfoDao busInfo = new BusInfoDaoImpl();
		
		System.out.println("Enter Bus Number");
		int busNo = sc.nextInt();
		System.out.println("Enter New Depature Date and Time");
		LocalDateTime depDate = LocalDateTime.parse(sc.next());
		System.out.println("Enter New Destination Arrival Date and Time");
		LocalDateTime arrDate = LocalDateTime.parse(sc.next());
		
		try {
			
			if(busInfo.updateBusDate(busNo, depDate, arrDate)) {
				System.out.println(Colors.GREEN_BACKGROUND+" Bus DateTime Changed"+Colors.RESET);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				AdminDashboard.adminDashboard(sc);
				
			}
			
		} catch (SomeThingWentWrong e) {
			e.printStackTrace();
			AdminDashboard.adminDashboard(sc);
		}
		
	}
	
	public static void getBusList(Scanner sc) {
		
		BusInfoDao busInfo = new BusInfoDaoImpl();
		
		try {
			busInfo.getBusInfo().forEach(System.out::println);;
			
		} catch (SomeThingWentWrong e) {
			
			e.printStackTrace();
			
			AdminDashboard.adminDashboard(sc);
		}
	}
	
}