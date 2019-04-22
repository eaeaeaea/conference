package com.nea.ConferenceScheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.nea.ConferenceScheduler.entity.Speech;

public interface SpeechRepository extends CrudRepository<Speech, Long> {
}