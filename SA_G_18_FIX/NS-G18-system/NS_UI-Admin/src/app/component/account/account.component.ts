import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { AccountService } from 'src/app/service/account.service';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})

export class AccountComponent implements OnInit {
  recordINOUT: Array<any>;
  recordDepart: Array<any>;
  recordType: Array<any>;

  startDate = new Date(1990, 0, 1);
  views: any = {
    inputTime: null,
    title: null,
    inoutSelect: null,
    departSelect: null,
    TypeSelect: null,
    amount: null
  };

  constructor(private accountService: AccountService, private httpClient: HttpClient,private Router:Router) {
  }

  ngOnInit() {
    this.accountService.getIncomeExpenses().subscribe(data => {
      this.recordINOUT = data;
      console.log(this.recordINOUT);
    });

    this.accountService.getDepartments().subscribe(data => {
      this.recordDepart = data;
      console.log(this.recordDepart);
    });

    this.accountService.getGiveTo().subscribe(data => {
      this.recordType = data;
      console.log(this.recordType);
    });
  }


  Save() {
    if (this.views.inputTime == null) {
      alert('กรุณากรอกวันที่');
    }  else if (this.views.title == null) {
      alert('กรุณากรอกรายการ');
    }  else if (this.views.inoutSelect == null) {
        alert('กรุณากระบุรายรับ/รายจ่าย');
    } else if (this.views.departSelect == null) {
        alert('กรุณาระบุแผนก');
    } else if (this.views.TypeSelect == null) {
        alert('กรุณาระบุรูปแบบการเงิน');
    } else if (this.views.amount == null) {
        alert('กรุณากรอกจำนวนเงิน');
    } else {
        this.SaveData();
        alert('บันทึกเรียบร้อย');

      }
  }
  SaveData() {
    this.httpClient.get('http://localhost:8080/AccountRecord/' + this.views.inputTime + '/' + this.views.title + '/'
      + this.views.inoutSelect + '/' + this.views.departSelect + '/' + this.views.TypeSelect + '/' + this.views.amount  , this.views)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
        },
        error => {
          console.log(this.views.inputTime);
          console.log(this.views.title);
          console.log(this.views.inoutSelect);
          console.log(this.views.departSelect);
          console.log(this.views.TypeSelect);
          console.log(this.views.amount);
          console.log('Error', error);
        }
      );



  }

}




