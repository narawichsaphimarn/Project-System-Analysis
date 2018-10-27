import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs';
import {AccountTable} from '../component/table/table.component';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  dataTemp = new Subject<string>();
  public API = '//localhost:8080';
  private serviceUrl = '//localhost:8080//AccountRecord';
  constructor(private http: HttpClient) { }

  getAccountRecord(): Observable<any> {
    return this.http.get(this.API + '/AccountRecord');
  }
  getDepartments(): Observable<any> {
    return this.http.get(this.API + '/Departments');
  }
  getGiveTo(): Observable<any> {
    return this.http.get(this.API + '/GiveTo');
  }
  getIncomeExpenses(): Observable<any> {
    return this.http.get(this.API + '/IncomeExpenses');
  }
  getRoom():Observable<AccountTable[]>{
    return this.http.get<AccountTable[]>(this.serviceUrl);
  }
}
