import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/service/account.service';
import { Observable } from 'rxjs/Observable';
import { DataSource } from '@angular/cdk/collections';

export interface AccountTable {
  idaccount: number;
  savedate: string;
  title: string;
  departments: {
    namedepartment: string;
  };
  incomeexpenses: string;
  giveTo: {
    giveTo: string;
  };
  amount: string;
}

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})

export class TableComponent implements OnInit {
  room: Array<any>;
  hotel: Array<any>;
  roomstatus: Array<any>;
  roomtype: Array<any>;
  select: any  = {
    hotelNameSelect: '',
    roomstatusSelected: '',
    roomtypeSelected: '',
    inputRoomPrice: '',
    inputRoomNumber: '',
    imgSelect: '',
    memberUserName: String
  }
  displayedColumns: string[] = ['idaccount', 'savedate', 'title', 'incomeexpenses', 'namedepartment', 'giveTo', 'amount'];
  dataSource = new Account(this.accountService);
  constructor(private accountService: AccountService) { }

  ngOnInit() {
  }

}
export class Account extends DataSource<any> {
  constructor(private accountService: AccountService) {
    super();
  }
  connect(): Observable<AccountTable[]> {
    return this.accountService.getRoom();
  }
  disconnect() {}
}
