import { Component, OnInit } from '@angular/core';
import { ActivityserviceService } from 'src/app/service/activityservice.service';
import { Router } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';


export interface PeriodicElement { //เก็บค่าโชว์
 
  activityName: string;
    kindName: string;
    genderName: string;
  day: string;
  room: number;
  num: number;
  time: string;
  age:string;
}


@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css'],
  
  
})

  

export class ActivitiesComponent implements OnInit {

  displayedColumns: string[] = ['activityName', 'kindName', 'gender', 'day','room','num','time','age']; //ตารางโชว์
  dataSource = new HistoryDataSource(this.relatedService);


  kinds: Array<any>;  //ป้อนค่าจากUI
  genders: Array<any>;
  rooms: Array<any>;
  times: Array<any>;
  ages: Array<any>;
  activitys: Array<any>;
  view: any={
    KindActivity:null,
    Gender:null,
    Age:null,
    Room:null,
    Time:null,
    ActivityNameInput:null,
    PeopleInput:null,
    DayInput:null


    
  }

  
  constructor(private relatedService: ActivityserviceService , private httpClient: HttpClient,private router : Router) { }

  ngOnInit() {
    this.relatedService.getKindActivity().subscribe(data => {
      this.kinds = data;
      console.log(this.kinds);
    });
    
    this.relatedService.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });

    this.relatedService.getAge().subscribe(data => {
      this.ages = data;
      console.log(this.ages);
    });

    this.relatedService.getRoom().subscribe(data => {
      this.rooms = data;
      console.log(this.rooms);
    });

    this.relatedService.getTime().subscribe(data => {
      this.times = data;
      console.log(this.times);
    });
   


    
  }
  
  Save(){
    if (this.view.ActivityNameInput == null) {
      alert('กรุณากรอกชื่อกิจกรรม');
    }
   if (this.view.KindActivity == null) {
      alert('กรุณาเลือกประเภทกิจกรรม');
    }
    else if (this.view.Gender == null) {
      alert('กรุณาเลือกเพศ');
    }
    else if( this.view.DayInput == null){
      alert('กรุณาเลือกวันที่');
    }
    else if (this.view.Room == null) {
      alert('กรุณาเลือกห้อง');
    }
    
    else if ((this.view.PeopleInput == null)||((this.view.PeopleInput.toUpperCase() >= 'A')&&(this.view.PeopleInput.toUpperCase() <= 'Z'))||
            ((this.view.PeopleInput >= 'ก')&&(this.view.PeopleInput <= 'ฮ'))) {
      alert('กรุณาใส่จำนวนคน');
    }
    else if (this.view.Time == null) {
      alert('กรุณาเลือกเวลา');
    }
    else if( this.view.Age == null){
      alert('กรุณาเลือกช่วงอายุ');
    }
    
    else{
      
        this.save_func();
        alert('บันทึกเรียบร้อย');
      }
  }
  save_func(){
    this.httpClient.get('http://localhost:8080/Activity/' +this.view.ActivityNameInput + '/' + this.view.KindActivity + '/' 
    + this.view.Gender+ '/' + this.view.DayInput+ '/' + this.view.Room + '/' + this.view.PeopleInput+ '/' + this.view.Time+ '/'
    + this.view.Age, this.view)
    .subscribe(
      data => {
          console.log('PUT Request is successful', data);
      },
      error => {
          console.log(this.view.ActivityNameInput);
          console.log(this.view.KindActivity);
          console.log(this.view.Gender);
          console.log(this.view.DayInput);
          console.log(this.view.Room);
          console.log(this.view.PeopleInput);
          console.log(this.view.Time);
          console.log(this.view.Age);
          
           console.log('Rrror', error);
     }
);
    }
    


    
  }
  export class HistoryDataSource extends DataSource<any> {
    constructor(private relatedService: ActivityserviceService ) {
     super();
    }
    connect(): Observable<History[]>{
     return this.relatedService.getAllActivity();
 
    }
    disconnect(){}
 }

  