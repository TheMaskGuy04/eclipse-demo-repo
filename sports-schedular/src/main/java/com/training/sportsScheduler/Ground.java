package com.training.sportsScheduler;

import java.util.ArrayList;
import java.util.List;

public class Ground {
	/**
	 * The name string will contain the groundName.
	 */
	private String name;
	/**
	 * The schedule list of type Schedule will contain details about the ground booking.
	 */
	private List<Schedule> schedule = new ArrayList<Schedule>();
	
	/**
	 * <p>This is a constructor of the class Ground it initializes the name variable. . .
	 * </p>
	 * @param name It is the name of the ground
	 */
	public Ground(String name) {
		super();
		this.name = name;
	}

	/**
	 * <p>This is a method adds the new schedule to the list of schedule. . .
	 * </p>
	 * <p>	schedule will contain Team name that has booked the ground along with the date and time for which they have booked.
	 * </p>
	 * @param schedule It is the instance of the class Schedule
	 */
	public void setSchedule(Schedule schedule) {
		this.schedule.add(schedule);
	}
	
	/**
	 * <p>This is a method returns the ground schedule. . .
	 * </p>
	 * <p>	schedule will contain Team name that has booked the ground along with the date and time for which they have booked.
	 * </p>
	 * @return the list of schedule
	 */
	public List<Schedule> getScheduleInfo() {
		return schedule;
	}
	
	/**
	 * @return the name of the ground
	 */
	public String getGroundName() {
		return name;
	}
	
	/**
	 * <p>This method is used to book the ground for a particular team with date and time. . .
	 * </p>
	 * <p>Schedule will contain Team that has booked the ground along with the date and time for which they have booked.
	 * </p>
	 * @param team It is the Team that is booking the ground
	 * @param date It is the date for which they want to book the ground
	 * @param startTime Game Starting time from which hour
	 * @param endTime Game Ending time at which hour
	 */
	public void bookGround(Team team, String date, int startTime, int endTime) {
		
		for(Schedule s: schedule) {
			if((s.getDate()).equals(date)) {
				if(startTime >= s.getStartTime() && startTime < s.getEndTime()) {
					System.out.println("Please Select another Slot!");
					return;
				}
				else if(endTime >= s.getStartTime() && endTime < s.getEndTime()) {
					System.out.println("Please Select another Slot!");
					return;
				}
			}
		}
		
		List<Player> players = team.getPlayers();
		
		for(Player p: players) {
			List<Schedule> schedule = p.getSchedule();
			
			for(Schedule s: schedule) {
				if((s.getDate()).equals(date)) {
					if(startTime >= s.getStartTime() && startTime < s.getEndTime()) {
						System.out.printf("%s is not available!\n", p.getName());
						return;
					}
					else if(endTime >= s.getStartTime() && endTime < s.getEndTime()) {
						System.out.printf("%s is not available!\n", p.getName());
						return;
					}
				}
			}
		}
		
		Schedule newSchedule = new Schedule(date, startTime, endTime, this, team);
		
		team.setNewSchedule(newSchedule);
		
		System.out.println("Congratulations, Your Slot is booked! Have a nice Play!");
		
		return;
	}
}
