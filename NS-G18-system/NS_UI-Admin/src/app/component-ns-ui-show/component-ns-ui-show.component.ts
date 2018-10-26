import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { Router } from '@angular/router';
import { RelatedInformationService } from '../service/relatedInformation-service/related-information.service';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/observable';
import { DataSource } from '@angular/cdk/collections';



export interface PeriodicElement {
  relatedinformationID: number;
  relatedinformationName: string;
  relatedinformationDay: string;
  relatedinformationTime: string;
  relatedinformationAddress: string;
  relatedinformationPhone: string;
  relatedinformationEmail: string;
  relatedinformationFacebook: string;
  relatedinformationLine: string;
  agencyTypeEntity: {
    agencyName: string;
  }
  contactTimeEntity: {
    contactTimeName: string;
  }
  countryEntity: {
    countryName: string;
  }
  provinceEntity: {
    provinceName: string;
  }
}



export class RoomdataSource extends DataSource<any>{
  constructor(private relatedService: RelatedInformationService){
    super();
  }
  connect(): Observable<PeriodicElement[]> {
    console.log('Hey.Guy');
    return this.relatedService.getShow();
  }
  disconnect(){}
}

@Component({
  selector: 'app-component-ns-ui-show',
  templateUrl: './component-ns-ui-show.component.html',
  styleUrls: ['./component-ns-ui-show.component.css']
})

export class ComponentNsUiShowComponent implements OnInit {
  AgencyType: Array<any>;
  Province: Array<any>;
  Country: Array<any>;
  ContactTime: Array<any>;
  RelatedInformation: Array<any>;
  view: any={
    id:'',
    agent: '',
    provin: '',
    country: '',
    Nameoforganization: '',
    Workingtime: '',
    Workingday: '',
    Addressagency: '',
    Contacttime: '',
    Inputdataphonenumber: '',
    Inputdatafacebook: null,
    Inputdataline: null,
    Inputdatae_mail: ''
  }
  select: any  = {
    relatedinformationID: '',
    relatedinformationName: '',
    relatedinformationDay: '',
    relatedinformationTime: '',
    relatedinformationAddress: '',
    relatedinformationPhone: '',
    relatedinformationEmail: '',
    relatedinformationFacebook: '',
    relatedinformationLine: '',
    agencyName: '',
    contactTimeName: '',
    countryName: '',
    provinceName: '',
  }

  displayedColumns: string[] = ['relatedinformationID','agencyName','relatedinformationName','countryName','provinceName','relatedinformationTime','relatedinformationDay','contactTimeName','relatedinformationAddress','relatedinformationPhone','relatedinformationEmail','relatedinformationFacebook','relatedinformationLine']
  dataSource = new RoomdataSource(this.relatedService);
  constructor(private relatedService: RelatedInformationService , private httpClient: HttpClient,private router : Router) { }

  ngOnInit() {
    this.relatedService.getAgencyName().subscribe(data => {
      this.AgencyType = data;
      console.log(this.AgencyType);
    });
    
    this.relatedService.getCountryName().subscribe(data => {
      this.Country = data;
      console.log(this.Country);
    });

    this.relatedService.getProvinceName().subscribe(data => {
      this.Province = data;
      console.log(this.Province);
    });

    this.relatedService.getContactTimeName().subscribe(data => {
      this.ContactTime = data;
      console.log(this.ContactTime);
    });
  }

  selectRow(row){
    this.select.relatedinformationID = row.relatedinformationID;
    this.select.relatedinformationName = row.relatedinformationName;
    this.select.relatedinformationDay = row.relatedinformationDay;
    this.select.relatedinformationTime = row.relatedinformationTime;
    this.select.relatedinformationAddress = row.relatedinformationAddress;
    this.select.relatedinformationPhone = row.relatedinformationPhone;
    this.select.relatedinformationEmail = row.relatedinformationEmail;
    this.select.relatedinformationFacebook = row.relatedinformationFacebook;
    this.select.relatedinformationLine = row.relatedinformationLine;
    this.select.agencyName = row.agencyTypeEntity.agencyName;
    this.select.contactTimeName = row.contactTimeEntity.contactTimeName;
    this.select.countryName = row.countryEntity.countryName;
    this.select.provinceName = row.provinceEntity.provinceName;

    this.view.id = this.select.relatedinformationID;
    this.view.Nameoforganization = this.select.relatedinformationName;
    this.view.Addressagency = this.select.relatedinformationAddress;
    this.view.Workingtime = this.select.relatedinformationTime;
    this.view.Workingday = this.select.relatedinformationDay;
    this.view.Inputdataphonenumber = this.select.relatedinformationPhone;
    this.view.Inputdatafacebook = this.select.relatedinformationFacebook;
    this.view.Inputdataline = this.select.relatedinformationLine;
    this.view.Inputdatae_mail = this.select.relatedinformationEmail;
    this.view.agent = this.select.agencyName;
    this.view.provin = this.select.provinceName;
    this.view.country = this.select.countryName;
    this.view.Contacttime = this.select.contactTimeName;

    console.log(this.view.id);
    console.log(this.view.Nameoforganization);
    console.log(this.view.Addressagency);
    console.log(this.view.Workingtime);
    console.log(this.view.Workingday);
    console.log(this.view.Inputdataphonenumber);
    console.log(this.view.Inputdatafacebook);
    console.log(this.view.Inputdataline);
    console.log(this.view.Inputdatae_mail);
    console.log(this.view.agent);
    console.log(this.view.provin);
    console.log(this.view.country);
    console.log(this.view.countryName);
  }

  updateType(){
    this.httpClient.put('http://localhost:8080/updateRelatedInformation/'+  this.view.id + '/' + this.view.Nameoforganization + '/' + this.view.Workingday  + '/' + this.view.Workingtime + '/' + this.view.Addressagency + '/' + this.view.Inputdataphonenumber + '/' + this.view.Inputdatae_mail + '/' + this.view.Inputdatafacebook + '/' + this.view.Inputdataline + '/' + this.view.agent + '/' + this.view.Contacttime + '/' + this.view.country + '/' + this.view.provin, this.view)

      .subscribe(
        data => {
          if(data){
            console.log('Success');
            this.refresh();
          }
            
        },
        error =>{
        console.log('Uncomplete',error);
      }
      );
  }
  refresh() {
    this.relatedService.getShow().subscribe((res) => {
      this.RelatedInformation = res;
      this.dataSource = new RoomdataSource(this.relatedService);
    });
  }
}
