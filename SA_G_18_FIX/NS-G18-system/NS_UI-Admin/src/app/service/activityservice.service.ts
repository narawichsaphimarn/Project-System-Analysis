import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ActivityserviceService {
  public API = '//localhost:8080';

private ServiceUrl = 'http://localhost:8080/Activity'

  constructor(private http: HttpClient) { }

  getKindActivity(): Observable<any> {
    return this.http.get(this.API + '/kindActivity');
  }

  getGender(): Observable<any> {
    return this.http.get(this.API + '/genders');
  }

  getRoom(): Observable<any> {
    return this.http.get(this.API + '/room');
  }

  getTime(): Observable<any> {
    return this.http.get(this.API + '/time');
  }
  getAge(): Observable<any> {
    return this.http.get(this.API + '/age');
  }
  getAllActivity():Observable<any>{
    return this.http.get(this.API + '/Activity');

  }
  

  
}
