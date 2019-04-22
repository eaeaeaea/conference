package com.nea.ConferenceScheduler.model;

import com.nea.ConferenceScheduler.dto.SpeechDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Schedule {
	private List<Track> tracks = new ArrayList<Track>();

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	public void addTrack(Track t){
		tracks.add(t);
	}

}
