package com.nea.ConferenceScheduler.dto;

public class ConferenceSessionDto {
	private Integer trackNo;
	private String startTime;
	private String endTime;
	private String title;

	public Integer getTrackNo() {
		return trackNo;
	}

	public void setTrackNo(Integer trackNo) {
		this.trackNo = trackNo;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
