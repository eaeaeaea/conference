package com.nea.ConferenceScheduler.controller;

import com.nea.ConferenceScheduler.dto.SpeechDto;
import com.nea.ConferenceScheduler.service.SpeechListService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class SpeechListController {
	
	private SpeechListService speechListService;
	
	public SpeechListController(SpeechListService speechListService){
		this.speechListService = speechListService;
	}

	@GetMapping("/speeches")
	public List<SpeechDto> getSpeeches() {
		return speechListService.getSpeechList();
	}
	
	@GetMapping("/speeches/{id}")
	public SpeechDto getSpeech(@PathVariable Long id) throws Exception {
		return speechListService.getSpeech(id);
	}
	
	@PostMapping("/speeches")
	public SpeechDto createSpeech(@Valid @RequestBody SpeechDto speech){
		return speechListService.createSpeech(speech);
	}
	
	@PutMapping("/speeches{id}")
	public SpeechDto replaceSpeech(@Valid @RequestBody SpeechDto newSpeech,@PathVariable Long id) throws Exception {
		return speechListService.replaceSpeech(newSpeech,id);
	}
	

	@DeleteMapping("/speeches/{id}")
	public void deleteSpeech(@PathVariable Long id) throws Exception {
		speechListService.deleteSpeech(id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
