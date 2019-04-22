package com.nea.ConferenceScheduler.model;

import java.util.ArrayList;
import java.util.List;

public class Track {
	private List<Session> morningSessions = new ArrayList<Session>();
	private List<Session> afternoonSessions = new ArrayList<Session>();
	private final static Integer morningWindow = 60 * 3;
	private final static Integer afternoonWindow = 60 * 4;
	private final static Integer networkingWindow = 60;

	public List<Session> getMorningSessions(){
		return morningSessions;
	}

	public List<Session> getAfternoonSessions(){
		return afternoonSessions;
	}


	public boolean insertSession(Session s) {
		if (insertMorningSession(s)){
			return true;
		}
		if(insertAfternoonSession(s)){
			return true;
		}
		return false;
	}

	private boolean insertMorningSession(Session s) {
		Integer remainingTime= calculateRemainingTime(morningSessions, morningWindow);
		if(remainingTime >= s.getDuration()){
			s.setStartTime(calculateNewStartTime(morningSessions));
			morningSessions.add(s);
			return true;
		}
		return false;
	}

	private boolean insertAfternoonSession(Session s) {
		Integer remainingTime= calculateRemainingTime(afternoonSessions, afternoonWindow);
		if(remainingTime >= s.getDuration()){
			s.setStartTime(calculateNewStartTime(afternoonSessions));
			afternoonSessions.add(s);
			return true;
		}
		return false;
	}
	
	public boolean fillNetworkingTime() {
		Integer remainingTime = calculateRemainingTime(afternoonSessions, afternoonWindow);
		if (remainingTime > 0) {
			Session s = new Session();
			s.setDuration(Math.min(networkingWindow, remainingTime));
			s.setStartTime(afternoonWindow - s.getDuration());
			s.setTitle("Networking");
			afternoonSessions.add(s);
			return true;
		}
		return false;
	}

	private Integer calculateNewStartTime(List<Session> sessions){
		return sessions.stream().mapToInt(s -> s.getDuration()).sum();
	}


	private Integer calculateRemainingTime(List<Session> sessions, Integer totalMinutes) {
		return totalMinutes - sessions.stream().mapToInt(s -> s.getDuration()).sum();
	}
}
