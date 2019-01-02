import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ElderService } from 'src/app/service/elder.service';
import { from } from 'rxjs';
import { Observable } from 'rxjs/Observable';
import { DataSource } from '@angular/cdk/collections';
import { elderTable } from '../component-thaksin/component-thaksin.component';


@Component({
  selector: 'app-component-thaksin',
  templateUrl: './component-thaksin.component.html',
  styleUrls: ['./component-thaksin.component.css']
})
export class ComponentThaksinComponent implements OnInit {
  elderTable: Array<any>;
  gender: Array<any>;
  relative: Array<any>;
  statusMarital: Array<any>;
  allergic: Array<any>;
  select: any = {
    genderSelected: '',
    relativeSelected: '',
    statusMaritalSelected: '',
    allergicSelected: '',
    nameEldeInput: '',
    lastNameEldeInput: '',
    personalElderInput: '',
    birthDateElderInput: '',
    congenitalDiseaseInput: ''
  }
  minDate = new Date(1900, 0, 1);
  maxDate = new Date(1980, 0, 0);

  



  displayedColumns: string[] = ['position', 'name', 'lastname',  'personalId', 'congenitalDisease','relative'];
  dataSource = new ElderDataSource(this.elderService);


  constructor(private elderService: ElderService, private httpClient: HttpClient) { }
  ngOnInit() {
    this.elderService.getGender().subscribe(data => {
      this.gender = data;
      console.log(this.gender);
    })
    this.elderService.getRelativeName().subscribe(data => {
      this.relative = data;
      console.log(this.relative);
    })
    this.elderService.getStatusMaritalName().subscribe(data => {
      this.statusMarital = data;
      console.log(this.statusMarital);
    })
    this.elderService.getAllergicName().subscribe(data => {
      this.allergic = data;
      console.log(this.allergic);
    })

  }
  add() {
    if (this.select.nameEldeInput === '' || this.select.lastNameEldeInput === '' || this.select.genderSelected === '' || this.select.personalElderInput === '' || this.select.birthDateElderInput === '' || this.select.statusMaritalSelected === '' || this.select.allergicSelected === '') {
      console.log(this.select.nameEldeInput);
      console.log(this.select.lastNameEldeInput);
      console.log(this.select.genderSelected);
      console.log(this.select.personalElderInput);
      console.log(this.select.birthDateElderInput);
      console.log(this.select.statusMaritalSelected);

      console.log(this.select.allergicSelected);
      alert('กรุณา ระบุข้อมูลให้ครบถ้วน');
    }
    else {
      if (this.select.congenitalDiseaseInput === '') {
        this.select.congenitalDiseaseInput = '-';
      }
      console.log(this.select.congenitalDiseaseInput);
      if (this.select.personalElderInput > 999999999999 && this.select.personalElderInput < 10000000000000) {
        this.httpClient.get('http://localhost:8080/elder/' + this.select.nameEldeInput + '/' + this.select.lastNameEldeInput + '/' + this.select.genderSelected + '/' + this.select.personalElderInput + '/' + this.select.birthDateElderInput + '/' + this.select.statusMaritalSelected + '/' + this.select.congenitalDiseaseInput, this.select)
          .subscribe(


            data => {

              if (data) {
                console.log('PUT Request is successful', data);
                this.refresh();
                alert('บันทึกข้อมูลเรียบร้อย');
                this.httpClient.get('http://localhost:8080/allergicelder/' + this.select.nameEldeInput + '/' + this.select.allergicSelected, this.select)
                  .subscribe(
                    newData => {
                      console.log('Save many Success', newData)
                    }
                  )
                this.httpClient.get('http://localhost:8080/relativeelder/' + this.select.nameEldeInput + '/' + this.select.relativeSelected, this.select)
                  .subscribe(
                    newData2 => {
                      console.log('Save many Success', newData2)
                    }
                  )

                console.log('success', data)
                location.reload();
              }
              else
                alert('เลขขัตรประชาชนถูกใช้ไปแล้ว ' + this.select.personalElderInput)


            },
            error => {
              console.log('Error', error);
            }
          )
      }
      else {

        alert('กรุณา ระบุข้อมูลให้ถูกต้อง');

      }
    }

  }

  refresh() {
    this.elderService.getElder().subscribe((res) => {
      this.elderTable = res;
      this.dataSource = new ElderDataSource(this.elderService);
    });
  }


}
export class ElderDataSource extends DataSource<any>{
  constructor(private elderService: ElderService) {
    super();
  }
  connect(): Observable<elderTable[]> {
    return this.elderService.getElder()/*,this.elderService.getElder1()*/;
  }


  disconnect() { }
}
export interface elderTable {
  elder:{
    elderId: Number;
  elderName: string;
  elderLastName: string;
  congenitalDisease: string;
  elderPersonalId: string;
  }
  relative:{
    relativeName: String;
    relativeLastName: String;
  }
  
}
