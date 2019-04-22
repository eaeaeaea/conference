import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpeechService {

  private baseUrl = '/api/v1/speeches';

  constructor(private http: HttpClient) { }

  getSpeech(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createSpeech(speech: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, speech);
  }

  updateSpeech(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteSpeech(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getSpeechList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
