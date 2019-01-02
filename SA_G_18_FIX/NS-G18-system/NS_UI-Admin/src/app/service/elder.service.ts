import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { elderTable } from '../component/component-thaksin/component-thaksin.component';

@Injectable({
  providedIn: 'root'
})
export class ElderService {
  public API = '//localhost:8080';

  private serviceUrl= 'http://localhost:8080/relativeelders';
  // private serviceUrl1= 'http://localhost:8080/allergicelders';
 
  constructor(private http: HttpClient) { }
  getGender():Observable<any>{
    return this.http.get(this.API + '/genders');
  }
  getRelativeName():Observable<any>{
    return this.http.get(this.API + '/relatives');
  }
  getStatusMaritalName():Observable<any>{
    return this.http.get(this.API + '/statusmaritals');
  }
  getAllergicName():Observable<any>{
    return this.http.get(this.API + '/allergics');
  }
  getElder():Observable<elderTable[]>{
    return this.http.get<elderTable[]>(this.serviceUrl);
  }

  /*getElder1():Observable<elderTable[]>{
    return this.http.get<elderTable[]>(this.serviceUrl1);
  }*/

}
