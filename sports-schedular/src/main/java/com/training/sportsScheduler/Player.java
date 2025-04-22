package com.training.sportsScheduler;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name, address;
	private List<Schedule> schedule = new ArrayList<Schedule>();
	
	/**
	 * <p>This is a constructor for Player Class. . .
	 * </p>
	 * <p> It initializes the player name and address
	 * </p>
	 * @param name String in which player will store its name
	 * @param address String in which player will store its address
	 */
	public Player(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	
	/**
	 * <p>This methods add new schedule for player. . .
	 * </p>
	 * <p> It add new Schedule in the schedule list
	 * </p>
	 * @param schedule Object of Schedule Class
	 */
	public void addNewSchedule(Schedule schedule) {
		this.schedule.add(schedule);
	}
	
	
	/**
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p> Allows player to change their name
	 * </p>
	 * @param name, new name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p> Allows player to change their address
	 * </p>
	  * @param address, new address of the player
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	* @return the address of the player
	 */
	public String getAddress() {
		return address;
	}

	/**
	* @return the List that contains the schedules of the player
	 */
	public List<Schedule> getSchedule() {
		return schedule;
	}
}
