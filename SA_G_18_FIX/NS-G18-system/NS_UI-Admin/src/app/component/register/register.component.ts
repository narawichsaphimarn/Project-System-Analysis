import { HttpClient } from '@angular/common/http';
import { RegisterService } from 'src/app/service/register/register.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})

export class RegisterComponent implements OnInit {
  Titlename: Array<any>;
  statusMarital: Array<any>;
  Religion: Array<any>;
  Position: Array<any>;
  Nationality: Array<any>;
  Ethnicity: Array<any>;
  Gender:Array<any>;
  view: any={
    firstname:'',
    lastname:'',
    gender: '', //sex
    identificationnumber:'',
    phone:'',
    email:'',
    titlename:'',
    nationality:'',
    ethnicity:'',
    religion:'',
    position:'',
    statusmarital:'' //status
  }
  
  constructor(private registerService: RegisterService, private httpClient: HttpClient ) { }
  ngOnInit() {
    this.registerService.getTitlename().subscribe(titlename => {
      this.Titlename = titlename;
      console.log(this.Titlename);
    });

    this.registerService.getNationality().subscribe(nationality => {
      this.Nationality = nationality;
      console.log(this.Nationality);
    });

    this.registerService.getEthnicity().subscribe(ethnicity => {
      this.Ethnicity = ethnicity;
      console.log(this.Ethnicity);
    });

    this.registerService.getReligion().subscribe(religion => {
      this.Religion = religion;
      console.log(this.Religion);
    });
    this.registerService.getPosition().subscribe(position => {
      this.Position = position;
      console.log(this.Position);
    });
    //status
    this.registerService.getStatusMaritalName().subscribe(statusmarital => {
      this.statusMarital = statusmarital;
      console.log(this.statusMarital);
    })
    //sex
    this.registerService.getGender().subscribe(gender => {
      this.Gender = gender;
      console.log(this.Gender);
    })

   
  

  }
  onSave(){
    console.log(this.view.firstname);
    console.log(this.view.lastname);
    console.log(this.view.gender);
    console.log(this.view.identificationnumber);
    console.log(this.view.phone);
    console.log(this.view.email);
    console.log(this.view.titlename);
    console.log(this.view.nationality);
    console.log(this.view.ethnicity);
    console.log(this.view.religion);
    console.log(this.view.position);
    console.log(this.view.statusMarital);
    this.httpClient.get('http://localhost:8080/Profile/'+ this.view.firstname + '/' + this.view.lastname + '/' + this.view.gender + '/' + this.view.identificationnumber + '/' + this.view.phone + '/' + this.view.email + '/' + this.view.titlename + '/' + this.view.nationality + '/' + this.view.ethnicity + '/' + this.view.religion + '/' + this.view.position + '/' + this.view.statusmarital,this.view)
    .subscribe
    (
      data =>{
      alert('บันทึกเรียบร้อย');
      console.log('Post Request is seccessful',data);
    },
    error=>{
      console.log('Rrror',error);
      alert('ไม่สามารถบันทึกได้ โปรดกรุณาใส่ข้อมูลให้ครบถ้วน');
    }
    );
  }
}




