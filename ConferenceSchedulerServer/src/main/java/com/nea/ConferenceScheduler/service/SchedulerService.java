package com.nea.ConferenceScheduler.service;

import java.util.List;

import com.nea.ConferenceScheduler.dto.ConferenceSessionDto;
import com.nea.ConferenceScheduler.dto.SpeechDto;
import com.nea.ConferenceScheduler.model.Schedule;

public interface SchedulerService {

	List<ConferenceSessionDto> getConferenceSessions(List<SpeechDto> speeches) throws Exception;
}
