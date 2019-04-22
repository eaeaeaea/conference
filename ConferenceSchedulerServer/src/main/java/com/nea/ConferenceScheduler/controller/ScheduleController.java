package com.nea.ConferenceScheduler.controller;

import com.nea.ConferenceScheduler.dto.ConferenceSessionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nea.ConferenceScheduler.model.Schedule;
import com.nea.ConferenceScheduler.service.SchedulerService;
import com.nea.ConferenceScheduler.service.SpeechListService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ScheduleController {
	
	private SchedulerService schedulerService;
	
	private SpeechListService speechListService;
	
	public ScheduleController(SchedulerService schedulerService, SpeechListService speechListService){
		this.schedulerService = schedulerService;
		this.speechListService = speechListService;
	}
	
	@GetMapping("/sessions")
	public List<ConferenceSessionDto> getSchedule() throws Exception {
		return schedulerService.getConferenceSessions(speechListService.getSpeechList());
	}

}
