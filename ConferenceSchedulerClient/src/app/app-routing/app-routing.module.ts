import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateSpeechComponent } from '../components/create-speech/create-speech.component';
import { SpeechListComponent } from '../components/speech-list/speech-list.component';
import {ScheduleComponent} from '../components/schedule/schedule.component';

const routes: Routes = [
  { path: '', redirectTo: 'speech', pathMatch: 'full' },
  { path: 'speeches', component: SpeechListComponent },
  { path: 'add', component: CreateSpeechComponent },
  { path: 'schedule', component: ScheduleComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
