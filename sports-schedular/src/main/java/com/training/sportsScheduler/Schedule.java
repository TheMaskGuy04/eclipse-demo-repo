package com.training.sportsScheduler;

public class Schedule {
	private String date;
	private int startTime, endTime;
	private Ground ground;
	private Team team;
	
	/**
	 * <p>This is a constructor for Schedule Class. . .
	 * </p>
	 * <p> It initializes the date, time, ground and team for the particular game schedule
	 * </p>
	 * @param date It is the date for which they want to book the ground
	 * @param startTime Game Starting time from which hour
	 * @param endTime Game Ending time at which hour
	 * @param ground Ground on which game will be played
	 * @param team Team which will be playing the game
	 */
	public Schedule(String date, int startTime, int endTime, Ground ground, Team team) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ground = ground;
		this.team = team;
	}

	/**
	 * @return the date of the game
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return the starting time of the game
	 */
	public int getStartTime() {
		return startTime;
	}


	/**
	 * @return the ending time of the game
	 */
	public int getEndTime() {
		return endTime;
	}


	/**
	 * @return the Ground object on which game will be played
	 */
	public Ground getGround() {
		return ground;
	}
	
	
	/**
	 * @return the Team object that will be playing the game
	 */
	public Team getTeam() {
		return team;
	}
}
