import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SpeechService } from '../../speech.service';
import { Speech } from '../../model/speech';


@Component({
  selector: 'app-speech-list',
  templateUrl: './speech-list.component.html',
  styleUrls: ['./speech-list.component.css']
})
export class SpeechListComponent implements OnInit {
  speeches: Observable<Speech[]>;

  constructor(private speechService: SpeechService) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.speeches = this.speechService.getSpeechList();
  }

  deleteSpeech(id: number) {
    this.speechService.deleteSpeech(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
}
