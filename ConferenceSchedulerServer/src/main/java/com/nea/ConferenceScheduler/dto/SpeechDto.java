package com.nea.ConferenceScheduler.dto;


import javax.validation.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;

public class SpeechDto {

    private Long id;
	@NotBlank(message= "Title is mandatory")
    private String title;
	@DecimalMin(value="0", message="Duration must be positive integer.")
	private Integer duration;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
