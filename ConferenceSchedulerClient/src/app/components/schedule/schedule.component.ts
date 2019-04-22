import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {ConferenceSession} from '../../model/conferenceSession';
import {ScheduleService} from '../../schedule.service';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  sessions: Observable<ConferenceSession[]>;
  constructor(private scheduleService: ScheduleService) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.sessions = this.scheduleService.getSessionList();
  }
}
