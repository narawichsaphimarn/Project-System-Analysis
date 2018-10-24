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
  RelatedInformation: Array<any>;
  view: any={
    agent: '',
    provin: '',
    country: '',
    RIName: ''
  }

  displayedColumns: string[] = ['relatedinformationID','agencyName','relatedinformationName','countryName','provinceName','relatedinformationTime','relatedinformationDay','contactTimeName','relatedinformationAddress','relatedinformationPhone','relatedinformationEmail','relatedinformationFacebook','relatedinformationLine']
  dataSource = new RoomdataSource(this.relatedService);
  constructor(private relatedService: RelatedInformationService , private httpClient: HttpClient,private router : Router) { }

  ngOnInit() {
  }

  updateType(){
    // this.httpClient.get('http://localhost:8080/RelatedInformation/'+  this.view.RIName, this.view)

    //   .subscribe(
    //     data => {
    //       console.log('RIName NS', data);
    //     },
    //     error => {
    //       console.log('Rrror', error);
    //     }
    //   );
    this.relatedService.getRIName(this.view.RIName).subscribe(data => {
      this.AgencyType = data;
      console.log(this.AgencyType);
    });
  }
}
