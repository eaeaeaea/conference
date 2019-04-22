package com.nea.ConferenceScheduler.util;

import com.nea.ConferenceScheduler.dto.ConferenceSessionDto;
import com.nea.ConferenceScheduler.model.Schedule;
import com.nea.ConferenceScheduler.model.Session;
import com.nea.ConferenceScheduler.model.Track;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ScheduleUtil {
    private static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

    public static  List<ConferenceSessionDto> convertToConferenceSessionList(Schedule schedule){
        List<ConferenceSessionDto> conferenceSessionDtos  = new ArrayList<ConferenceSessionDto>();
        List<Track> tracks = schedule.getTracks();
        for(int trackNo = 0; trackNo<tracks.size(); trackNo ++) {
            Track track = tracks.get(trackNo);
            Calendar c = Calendar.getInstance();
            addSessions(c, conferenceSessionDtos, track.getMorningSessions(), trackNo,true);
            addSessions(c, conferenceSessionDtos, track.getAfternoonSessions(), trackNo, false);
        }

        return conferenceSessionDtos;
    }

    private static void  addSessions( Calendar c,  List<ConferenceSessionDto> conferenceSessionDtos, List<Session> sessions, Integer trackNo, boolean morning){
        for (Session s : sessions) {
            ConferenceSessionDto confSession = new ConferenceSessionDto();
            confSession.setTitle(s.getTitle());
            confSession.setTrackNo(trackNo);
            if(morning){
                getMorningStart(c);
            }else{
                getAfternoonStart(c);
            }
            c.add(Calendar.MINUTE, s.getStartTime());
            confSession.setStartTime(formatter.format(c.getTime()));
            c.add(Calendar.MINUTE, s.getDuration());
            confSession.setEndTime(formatter.format(c.getTime()));
            conferenceSessionDtos.add(confSession);
        }
    }

    private static void getMorningStart(Calendar c){
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 0);
    }

    private static void getAfternoonStart(Calendar c){
        c.set(Calendar.HOUR_OF_DAY, 13);
        c.set(Calendar.MINUTE, 0);
    }




}
