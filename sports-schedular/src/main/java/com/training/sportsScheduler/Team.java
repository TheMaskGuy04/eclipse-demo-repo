package com.training.sportsScheduler;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private String teamName;
	private List<Player> players = new ArrayList<Player>();
	private List<Schedule> schedule = new ArrayList<Schedule>();
	
	/**
	 * <p>This is a constructor for Team Class. . .
	 * </p>
	 * <p> It initializes the team name and players list
	 * </p>
	 * @param teamName String in which team name will store its name
	 * @param players List in which Player objects will be there that are part of the team.
	 */
	public Team(String teamName, List<Player> players) {
		super();
		this.teamName = teamName;
		this.players = players;
	}
	
	/**
	 * @return the name of the team
	 */
	public String getTeamName() {
		return teamName;
	}
	
	
	/**
	 * <p>This methods add new schedule for team. . .
	 * </p>
	 * <p> It add new Schedule in the schedule list
	 * </p>
	 * @param newSchedule New game schedule for player
	 */
	public void setNewSchedule(Schedule newSchedule) {
		schedule.add(newSchedule);
		
		for(Player p: players) {
			p.addNewSchedule(newSchedule);
		}
	}
	
	/**
	* @return the list of the all players that are part of this team
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	* @return the List that contains the schedules of the team
	 */
	public List<Schedule> getSchedule() {
		return schedule;
	}
	
}
