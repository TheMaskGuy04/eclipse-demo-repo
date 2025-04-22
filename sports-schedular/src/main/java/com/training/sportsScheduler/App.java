package com.training.sportsScheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class App {
	/**
	 * <p>This is the main method that creates the simulation for the whole Sports Scheduler. . .
	 */
	public static void main(String[] args) throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		Handler handler = new Handler();
		
		
		System.out.println("Welcome to My Sports Scheduler");
		System.out.println("Initializing...");
		handler.createNewGround("G1");
		handler.createNewGround("G2");
		
		while(true) {
			System.out.print("\n1. Create New Player  ");
			System.out.print("2. Create New Team  ");
			System.out.print("3. Create New Ground  ");
			System.out.print("4. Get Player Info  \n");
			System.out.print("5. Get Team Info  ");
			System.out.print("6. Get Ground Info  ");
			System.out.print("7. Book a Ground  ");
			System.out.println("8. Exit  ");
			
			System.out.print("Enter your choice: ");
			String choice = sc.nextLine();
			
	        
	        if(choice.equals("8")) {
	        	System.out.println("Thank You! Have a nice day");
	        	break;
	        }
	        
	        switch(choice) {
	        	case "1": {
	        		System.out.print("Enter Player Name: ");
	        		String playerName = sc.nextLine();
	        		
	        		System.out.print("Enter Player Address: ");
	        		String playerAdd = sc.nextLine();
	        		
	        		handler.createNewPlayer(playerName, playerAdd);
	        		break;
	        	}
	        	case "2": {
        			System.out.print("Enter Team Name: ");
	        		String teamName = sc.nextLine();
	        		
	        		System.out.print("Enter no. of players: ");
	        		int totalPlayer = sc.nextInt();
	        		sc.nextLine();
	        		
	        		HashSet<String> players = new HashSet<String>();
	        		
	        		for(int i = 0; i< totalPlayer; i++) {
	        			System.out.print("Enter Player's Name: ");
		        		String name = sc.nextLine();
		        		
		        		if(players.contains(name)) {
		        			System.out.println("Player's Name Repeated!!!");
		        			i--;
		        		}
		        		else {
		        			players.add(name);
		        		}
	        		}
	        		
	        		handler.createNewTeam(teamName, players);
	        		break;
	        	}
	        	case "3": {
	        		System.out.print("Enter Ground's Name: ");
	        		String groundName = sc.nextLine();
	        		
	        		handler.createNewGround(groundName);
	        		break;
	        	}
	        	case "4": {
	        		System.out.print("Enter Player's Name: ");
	        		String playerName = sc.nextLine();
	        		
	        		handler.getPlayerInfo(playerName);
	        		break;
	        	}
	        	case "5": {
	        		System.out.print("Enter Team's Name: ");
	        		String teamName = sc.nextLine();
	        		
	        		handler.getTeamInfo(teamName);
	        		break;
	        	}
	        	case "6": {
	        		System.out.print("Enter Ground's Name: ");
	        		String groundName = sc.nextLine();
	        		
	        		handler.getGroundInfo(groundName);
	        		break;
	        	}
	        	case "7": {
	        		System.out.println("Note: First you have to create Team and then only you can book a ground");
	        		System.out.print("Enter Ground's Name: ");
	        		String groundName = sc.nextLine();

	        		System.out.print("Enter Team's Name: ");
	        		String teamName = sc.nextLine();
	        		
	        		System.out.print("Enter Date in dd/mm/yyyy format: ");
	        		String date = sc.nextLine();
	        		
	        		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        		String currentDate = simpleDateFormat.format(new Date());
	        		
	        		Date a = simpleDateFormat.parse(date);
	                Date b = simpleDateFormat.parse(currentDate);
	                
	        		if(!a.equals(b) && a.before(b)) {
	        			System.out.println("Your Date: " + date +" is before Current Date: " + currentDate);
	        			break;
	        		}

//	        		Calendar rightNow = Calendar.getInstance();
//	        		int current_hour = rightNow.get(Calendar.HOUR_OF_DAY);
	        				
	        		System.out.print("Enter Starting hour in 24 hours clock format: ");
	        		int startTime = sc.nextInt();
	        		sc.nextLine();
	        		
	        		System.out.print("Enter Ending hour in 24 hours clock format: ");
	        		int endTime = sc.nextInt();
	        		sc.nextLine();
	        		
	        		handler.bookGround(groundName, teamName, date, startTime, endTime);
	        		break;
	        	}
	        	default: 
	        		System.out.println("Invalid Choice");
	        		break;
	        }
		}
	}
}

