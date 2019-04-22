import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeechDetailsComponent } from './speech-details.component';

describe('SpeechDetailsComponent', () => {
  let component: SpeechDetailsComponent;
  let fixture: ComponentFixture<SpeechDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpeechDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpeechDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
