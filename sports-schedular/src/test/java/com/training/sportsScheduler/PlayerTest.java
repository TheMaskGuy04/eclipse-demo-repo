package com.training.sportsScheduler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Player p;
	
	@BeforeEach
	public void init(){
		p = new Player("Miral", "Bhiwandi");
	}
	
	@Test
	void checkingGetName() {
		String actual = p.getName();
		String expected = "Miral";
		
		assertEquals(expected, actual);
	}

	
	@Test
	void checkingIfScheduleIsAdded() {
		Ground g1 = new Ground("G1");
		List<Player> players = new ArrayList<Player>();
		players.add(p);
		Team t1 = new Team("T1", players);
		
		Schedule schedule = new Schedule("22/04/2025", 22, 23, g1, t1);
		
		p.addNewSchedule(schedule);
		
		List<Schedule> actual = p.getSchedule();
		
		List<Schedule> expected = new ArrayList<Schedule>();
		expected.add(schedule);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void checkingGetAddress() {
		String actual = p.getAddress();
		String expected = "Bhiwandi";
		
		assertEquals(expected, actual);
	}
	
	@Test
	void checkingSetName() {
		p.setName("Prashant");
		String actual = p.getName();
		String expected = "Prashant";
		
		assertEquals(expected, actual);
	}
	
	@Test
	void checkingSetAddress() {
		p.setAddress("Dahisar");
		String actual = p.getAddress();
		String expected = "Dahisar";
		
		assertEquals(expected, actual);
	}
}
