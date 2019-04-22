package com.nea.ConferenceScheduler.model;

import com.nea.ConferenceScheduler.dto.SpeechDto;

public class Session {
	private Integer duration;
	private String title;
	private Integer startTime;

	public Session(){
	}
	public Session(SpeechDto speechdto){
		this.duration = speechdto.getDuration();
		this.title = speechdto.getTitle();
	}
	
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
}
