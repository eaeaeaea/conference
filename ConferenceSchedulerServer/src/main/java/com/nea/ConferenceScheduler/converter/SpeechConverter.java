package com.nea.ConferenceScheduler.converter;

import org.springframework.beans.BeanUtils;

import com.nea.ConferenceScheduler.dto.SpeechDto;
import com.nea.ConferenceScheduler.entity.Speech;

public class SpeechConverter {

	public static  SpeechDto convertToDto(Speech speech) {
		SpeechDto speechDto = new SpeechDto();
		BeanUtils.copyProperties(speech, speechDto);
	    return speechDto;
	}
	
	public static Speech convertToEntity(SpeechDto speechDto){
		Speech speech = new Speech();
		BeanUtils.copyProperties(speechDto, speech);
	    return speech;
	}
}
