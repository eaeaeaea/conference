package com.nea.ConferenceScheduler.service;

import java.util.List;

import com.nea.ConferenceScheduler.dto.SpeechDto;

public interface SpeechListService {

	List<SpeechDto> getSpeechList();

	SpeechDto getSpeech(Long id) throws Exception;

	SpeechDto createSpeech(SpeechDto speech);

	SpeechDto replaceSpeech(SpeechDto speech, Long id) throws Exception;

	void deleteSpeech(Long id) throws Exception;

}
