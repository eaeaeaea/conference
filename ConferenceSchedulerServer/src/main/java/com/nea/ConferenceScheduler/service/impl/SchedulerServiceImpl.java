package com.nea.ConferenceScheduler.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.nea.ConferenceScheduler.dto.ConferenceSessionDto;
import com.nea.ConferenceScheduler.util.ScheduleUtil;
import org.springframework.stereotype.Service;

import com.nea.ConferenceScheduler.dto.SpeechDto;
import com.nea.ConferenceScheduler.entity.Speech;
import com.nea.ConferenceScheduler.model.Schedule;
import com.nea.ConferenceScheduler.model.Session;
import com.nea.ConferenceScheduler.model.Track;
import com.nea.ConferenceScheduler.service.SchedulerService;

@Service
public class SchedulerServiceImpl implements SchedulerService {


	@Override
	public List<ConferenceSessionDto> getConferenceSessions(List<SpeechDto> speeches) throws Exception {
		Schedule schedule = makeSchedule(speeches);
		return ScheduleUtil.convertToConferenceSessionList(schedule);
	}

	public Schedule makeSchedule(List<SpeechDto> speechDtos) throws Exception {
		Schedule schedule = new Schedule();
		speechDtos.sort(Comparator.comparing(SpeechDto::getDuration).reversed());
		Track track = new Track();
		for(SpeechDto speechDto: speechDtos){
			if(!track.insertSession(new Session(speechDto))){
				schedule.addTrack(track);
				track = new Track();
				if(!track.insertSession(new Session(speechDto))){
					throw new Exception("Event duration too long, title: " + speechDto.getTitle() + ", duration: " + speechDto.getDuration());
				}
			}
		}
		schedule.addTrack(track);
		addNetworkingEvents(schedule);
		return schedule;
	}

	private void addNetworkingEvents(Schedule schedule){
		for(Track track: schedule.getTracks()){
			track.fillNetworkingTime();
		}
	}
}
