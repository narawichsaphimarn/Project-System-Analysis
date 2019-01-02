import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { RegisterService } from 'src/app/service/register/register.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { ShowService } from 'src/app/service/register/show.service';
import { DataSource } from '@angular/cdk/collections';


export interface Profile{
  profileId:number;
titlename:{
  titlename:string;
}
firstName:string;
lastName:String;
position:String;
email:String;
phone:String;
}

export class RoomDataSouse extends DataSource<any>{
  constructor(private registerService:RegisterService){
    super();
  }
  connect(): Observable<Profile[]>{
    return this.registerService.getShow();
  }
  disconnect(){}
}

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})

export class ShowComponent implements OnInit {
  displayedColumns: string[] = ['profileId', 'titlename', 'firstName','lastName','email','phone'];
  dataSource = new RoomDataSouse(this.registerService);
  profiles: Array<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  
  constructor(private showService: ShowService,private registerService: RegisterService,private httpClient: HttpClient) { }
  

  ngOnInit() {
   
  }
  // getProfileList(){
  //   this.showService.getProfile().subscribe(data => {
  //   this.profiles = data;
  //   const profileList:Profile[] = [];
  //   console.log(this.profiles);
    

  //   for (let index = 0; index < this.profiles["length"]; index++) {

  //     profileList.push({
  //       profileId: this.profiles[index].profileId,
  //       titlename: this.profiles[index].titlename.titlename,
  //       firstName: this.profiles[index].firstName,
  //       lastName: this.profiles[index].lastName,
  //       position: this.profiles[index].position.position,
  //       email:this.profiles[index].email,
  //       phone:this.profiles[index].phone,
  //     })
  //     }  
  //     this.dataSource = new MatTableDataSource(profileList);
  //     this.dataSource.paginator = this.paginator;
  //   });
  // }

}