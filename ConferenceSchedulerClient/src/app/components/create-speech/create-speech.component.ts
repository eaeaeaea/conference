import { Component, OnInit } from '@angular/core';
import { SpeechService } from '../../speech.service';
import { Speech } from '../../model/speech';

@Component({
  selector: 'app-create-speech',
  templateUrl: './create-speech.component.html',
  styleUrls: ['./create-speech.component.css']
})
export class CreateSpeechComponent implements OnInit {

  speech: Speech = new Speech();
  submitted = false;

  constructor(private speechService: SpeechService) { }

  ngOnInit() {
  }

  newSpeech(): void {
    this.submitted = false;
    this.speech = new Speech();
  }

  save() {
    this.speechService.createSpeech(this.speech)
      .subscribe(data => {
        console.log(data);
        }
        , error => {
          console.log(error);
        });
    this.speech = new Speech();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
