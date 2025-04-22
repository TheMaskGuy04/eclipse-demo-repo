package com.training.sportsScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Handler {
//	private List<Player> players = new ArrayList<Player>();
//	private List<Team> teams = new ArrayList<Team>();
//	private List<Ground> grounds = new ArrayList<Ground>();
	private HashMap<String, Player> players = new HashMap<String , Player>();
	private HashMap<String, Team> teams = new HashMap<String , Team>();
	private HashMap<String, Ground> grounds = new HashMap<String , Ground>();

	
	/**
	 * <p>This method creates new Player class object. . .
	 * </p>
	 * <p> It add the new player object in the HashMap with unique player name
	 * </p>
	 * @param playerName New player's name
	 * @param address New player's address
	 */
	public void createNewPlayer(String playerName, String address) {
		
		if(players.containsKey(playerName) == true) {
			System.out.println("Player with name " + playerName + " exist!");
		}
		else {
			Player newPlayer = new Player(playerName, address);
			players.put(playerName, newPlayer);
			System.out.println("New Player " + playerName + " created!");
		}
	}
	
	/**
	 * <p>This method creates new Team class object. . .
	 * </p>
	 * <p> It add the new team object in the HashMap with unique team name
	 * </p>
	 * @param teamName New team's name
	 * @param playersName Members(Player class objects) of the team
	 */
	public void createNewTeam(String teamName, HashSet<String> playersName) {
		if(teams.containsKey(teamName) == true) {
			System.out.println("Team with name " + teamName + " exist!");
		}
		else {
			List<Player> teamPlayers = new ArrayList<Player>();
			
			for(String s: playersName) {
				if(players.containsKey(s) == false) {
					System.out.println("Player " + s + " does not exist!");
					return;
				}
				else {
					Player player = players.get(s);
					teamPlayers.add(player);
				}
			}
			
			Team newTeam = new Team(teamName, teamPlayers);
			teams.put(teamName, newTeam);
			System.out.println("New Team " + teamName + " created!");
		}
		
	}
	
	/**
	 * <p>This method creates new Ground class object. . .
	 * </p>
	 * <p> It add the new ground object in the HashMap with unique ground name
	 * </p>
	 * @param groundName New grounds's name
	 */
	public void createNewGround(String groundName) {
		if(grounds.containsKey(groundName) == true) {
			System.out.println("Ground with name " + groundName + " exist!");
		}
		else {
			Ground newGround = new Ground(groundName);
			grounds.put(groundName, newGround);
			System.out.println("New Ground " + groundName + " created!");	
		}
	}
	
	/**
	 * <p>This method displays the particular team's information. . .
	 * </p>
	 * <p> It displays the Team members name and game schedules
	 * </p>
	 * @param teamName Team's name for which info is to be displayed
	 */
	public void getTeamInfo(String teamName) {
		
		if(teams.containsKey(teamName) == true) {
			Team t = teams.get(teamName);
			System.out.printf("Team Name: %s\nTeam Members:\n", teamName);
				
				List<Player> teamPlayers = t.getPlayers();
				List<Schedule> teamSchedule = t.getSchedule();
				
;				for(Player p: teamPlayers) {
					System.out.print(p.getName() + "  ");
			}
			System.out.print("\n");
			
			System.out.println("Team's Schedule:");
			for(Schedule s: teamSchedule) {
				System.out.printf("Ground: %s\nDate: %s,  From %d:00 to %d:00\n", s.getGround().getGroundName(), s.getDate(), s.getStartTime(), s.getEndTime());
			}
		}
		else 
		{
			System.out.println(teamName + " does not exist!");
		}
		
	}
	
	/**
	 * <p>This method displays the particular player's information. . .
	 * </p>
	 * <p> It displays the Player name, address and its game schedules
	 * </p>
	 * @param playerName Player's name for which info is to be displayed
	 */
	public void getPlayerInfo(String playerName) {

		if(players.containsKey(playerName) == true) {
			Player p = players.get(playerName);
			
			System.out.println("Player Name: " + playerName);
			System.out.println("Address: " + p.getAddress());
			
			List<Schedule> playerSchedule = p.getSchedule();
			
			System.out.println("Player's Schedule:");
			for(Schedule s: playerSchedule) {
				System.out.printf("Ground: %s\nDate: %s,  From %d:00 to %d:00\n", s.getGround().getGroundName(), s.getDate(), s.getStartTime(), s.getEndTime());
			}
			
		}
		else {
			System.out.println(playerName + " does not exist!");
		}
		
	}
	
	/**
	 * <p>This method displays the particular ground's information. . .
	 * </p>
	 * <p> It displays the Ground name and list of game scheduled on that ground
	 * </p>
	 * @param groundName Ground's name for which info is to be displayed
	 */
	public void getGroundInfo(String groundName) {
		
		if(grounds.containsKey(groundName) == true) {
			Ground g = grounds.get(groundName);
			
			List<Schedule> groundSchedule = g.getScheduleInfo();
			
			System.out.printf("Ground Name: %s\n", groundName);
			
			System.out.println("Ground's Schedule:");
			for(Schedule s: groundSchedule) {
				System.out.printf("Team: %s\nDate: %s,  From %d:00 to %d:00\n", s.getTeam().getTeamName(), s.getDate(), s.getStartTime(), s.getEndTime());
			}
		}
		else {
			
			System.out.println(groundName + " does not exist!");
		}
		
	}
	
	/**
	 * <p>This method schedules new game for a particular team on a particular ground for a particular date and time. . .
	 * </p>
	 * @param groundName Ground's name on which game will be played
	 * @param teamName Team's name that will be playing the game
	 * @param date It is the date for which they want to book the ground
	 * @param startTime Game Starting time from which hour
	 * @param endTime Game Ending time at which hour
	 */
	public void bookGround(String groundName, String teamName, String date, int startTime, int endTime) {
		
		Ground ground = null;
		Team team = null;
		
		if(grounds.containsKey(groundName) == false) {
			System.out.println("Ground does not exist!");
			return;
		}
		else {
			ground = grounds.get(groundName);
		}
		
		
		if(teams.containsKey(teamName) == false) {
			System.out.println("Team does not exist!");
			return;
		}
		else {
			team = teams.get(teamName);
		}
		
		
		ground.bookGround(team, date, startTime, endTime);
	}
}
