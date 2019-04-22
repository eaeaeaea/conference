import { Speech } from '../../model/speech';
import { Component, OnInit, Input } from '@angular/core';
import { SpeechService } from '../../speech.service';
import { SpeechListComponent } from '../speech-list/speech-list.component';

@Component({
  selector: 'app-speech-details',
  templateUrl: './speech-details.component.html',
  styleUrls: ['./speech-details.component.css']
})
export class SpeechDetailsComponent implements OnInit {

  @Input() speech: Speech;

  constructor(private speechService: SpeechService, private listComponent: SpeechListComponent) { }

  ngOnInit() {
  }
}
