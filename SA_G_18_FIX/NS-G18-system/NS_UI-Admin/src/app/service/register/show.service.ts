import { Observable } from 'rxjs/internal/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShowService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient ) { }

getTitleName(): Observable<any> {
    return this.http.get(this.API + '/Titlename');
  }
getPosition():Observable<any> {
    return this.http.get(this.API + '/Position');
  }
  getProfile(): Observable<any> {
    return this.http.get(this.API + '/Profile');
  }
}
