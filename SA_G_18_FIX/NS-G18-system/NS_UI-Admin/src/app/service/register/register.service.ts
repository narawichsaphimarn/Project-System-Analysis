import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';
import { Profile } from 'src/app/component/show/show.component';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  public API = '//localhost:8080';
  private serviceUrl = 'http://localhost:8080/Profiles';
  constructor(private http: HttpClient) { }

  getTitlename(): Observable<any> {
    return this.http.get(this.API + '/Titlename');
  }
  
  getStatusMaritalName(): Observable<any> {
    return this.http.get(this.API + '/statusmaritals');
  }

  getNationality():Observable<any> {
    return this.http.get(this.API + '/Nationality');
  }

  getEthnicity():Observable<any> {
    return this.http.get(this.API + '/Ethnicity');
  }

  getReligion():Observable<any> {
    return this.http.get(this.API + '/Religion');
  }

  getPosition():Observable<any> {
    return this.http.get(this.API + '/Position');
  }

  getGender():Observable<any> {
    return this.http.get(this.API + '/genders');
  }

  getnewProfile():Observable<any> {
    return this.http.get(this.API + '/newProfile');
  }

  getShow():Observable<Profile[]>{
    return this.http.get<Profile[]>(this.serviceUrl);
  }
}
