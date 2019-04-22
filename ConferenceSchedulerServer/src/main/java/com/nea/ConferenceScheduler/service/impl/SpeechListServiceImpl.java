package com.nea.ConferenceScheduler.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nea.ConferenceScheduler.converter.SpeechConverter;
import com.nea.ConferenceScheduler.dto.SpeechDto;
import com.nea.ConferenceScheduler.entity.Speech;
import com.nea.ConferenceScheduler.repository.SpeechRepository;
import com.nea.ConferenceScheduler.service.SpeechListService;

@Service
public class SpeechListServiceImpl implements SpeechListService {

	private final SpeechRepository speechRepository;

	SpeechListServiceImpl(SpeechRepository speechRepository) {
		this.speechRepository = speechRepository;
	}

	@Override
	public List<SpeechDto> getSpeechList() {
		List<Speech> speeches = (List<Speech>) speechRepository.findAll();
		return  speeches.stream().map(speech -> SpeechConverter.convertToDto(speech))
				.collect(Collectors.toList());
	}

	@Override
	public SpeechDto getSpeech(Long id) throws Exception {
		Optional<Speech> speech = speechRepository.findById(id);
		if (!speech.isPresent())
			throw new  Exception("Resource not found for this id :: " + id);
		return SpeechConverter.convertToDto(speech.get());
	}

	@Override
	public SpeechDto createSpeech(SpeechDto speechDto) {
		Speech speech = speechRepository.save(SpeechConverter.convertToEntity(speechDto));
		return SpeechConverter.convertToDto(speech);
	}

	@Override
	public SpeechDto replaceSpeech(SpeechDto speechDto, Long id) throws Exception {
		speechRepository.findById(id).orElseThrow(() -> new Exception("Resource not found for this id :: " + id));
		Speech speech = speechRepository.save(SpeechConverter.convertToEntity(speechDto));
		return SpeechConverter.convertToDto(speech);
	}

	@Override
	public void deleteSpeech(Long id) throws Exception {
		speechRepository.findById(id).orElseThrow(() -> new Exception("Resource not found for this id :: " + id));
		speechRepository.deleteById(id);
	}
}
