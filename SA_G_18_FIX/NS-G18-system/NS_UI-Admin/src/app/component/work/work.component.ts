import { Component, OnInit } from '@angular/core';
import { ActivityserviceService } from 'src/app/service/activityservice.service';
import { from } from 'rxjs';
import { Observable } from 'rxjs/Observable';
import { DataSource } from '@angular/cdk/collections';
import {work} from '../work/work.component';

@Component({
  selector: 'app-work',
  templateUrl: './work.component.html',
  styleUrls: ['./work.component.css']
})
export class WorkComponent implements OnInit {
  constructor(){
    
  }
  

  ngOnInit(){}



  displayedColumns: string[] = ['activity', 'kind', 'sex', 'day','room','num','time','age'];
  dataSource = ELEMENT_DATA;
}



export interface PeriodicElement {
  kind: string;
  activity: string;
  sex: string;
  day: string;
  room: number;
  num: number;
  time: string;
  age: String;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {activity: '', kind: '', sex: '', day: '',room:null ,num:null,time:'',age:''},
  {activity: '', kind: '', sex: '', day: '',room:null,num:null,time:'',age:''},
  {activity: '', kind: '', sex: '', day: '',room:null,num:null,time:'',age:''},

];
export interface work{
  activitys: string;
  nums: number;
  days: string;
  kinds:{
    kindss: string;
  }
  sexs:{
    sexx: string;
  }
  rooms:{
    roomss: number;
  }
  times:{
    timess: string;
  }
  ages:{
    agess: string;
  }




}