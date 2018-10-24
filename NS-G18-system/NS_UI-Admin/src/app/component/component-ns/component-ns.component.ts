import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelatedInformationService } from '../../service/relatedInformation-service/related-information.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-component-ns',
  templateUrl: './component-ns.component.html',
  styleUrls: ['./component-ns.component.css']
})
export class ComponentNsComponent implements OnInit {
  AgencyType: Array<any>;
  Province: Array<any>;
  Country: Array<any>;
  ContactTime: Array<any>;
  view: any={
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
  

  constructor(private relatedService: RelatedInformationService , private httpClient: HttpClient,private router : Router
  ) { }

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

  Save() {
    if (this.view.agent == null) {
      alert('กรุณาเลือกประเถทหน่วยงาน');
    }
    else if (this.view.provin == null) {
      alert('กรุณาเลือกจังหวัด');
    }
    else if(this.view.country == null) {
      alert('กรุณาเลือกประเทศ');
    }
    else if(this.view.Nameoforganization == '') {
      alert('กรุณาระบุชื่อหน่วยงาน');
    }
    else if(this.view.Workingtime == '') {
      alert('กรุณาระบุเวลาทำการ');
    }
    else if(this.view.Workingday == '') {
      alert('กรุณาระบุวันทำการ');
    }
    else if(this.view.Addressagency == '') {
        alert('กรุณาระบุที่อยู่หน่วยงาน');
    }
    else if(this.view.Contacttime == null) {
      alert('กรุณาระบุช่วงที่ติดต่อได้');
    }
    else if(this.view.Inputdataphonenumber == '') {
      alert('กรุณาระบุเบอร์โทรศัพท์');
    }
    // else if(this.view.Inputdatafacebook == ''){
    //   this.view.Inputdatafacebook = '';
    // }
    // else if(this.view.Inputdataline == ''){
    //   this.view.Inputdataline = '';
    // }
    else if(this.view.Inputdatae_mail == ''){
      alert('กรุณาระบุE-mail');
    }
    else {
    this.save_func();
    }
    console.log('agent',this.view.agent)
    console.log('provin',this.view.provin)
    console.log('country',this.view.country)
    console.log('Nameoforganization',this.view.Nameoforganization)
    console.log('Workingtime',this.view.Workingtime)
    console.log('Workingday',this.view.Workingday)
    console.log('Addressagency',this.view.Addressagency)
    console.log('Contacttime',this.view.Contacttime)
    console.log('Inputdataphonenumber',this.view.Inputdataphonenumber)
    console.log('Inputdatafacebook',this.view.Inputdatafacebook)
    console.log('Inputdataline',this.view.Inputdataline)
    console.log('Inputdatae_mail',this.view.Inputdatae_mail)
  }
  save_func(){
    this.httpClient.get('http://localhost:8080/RelatedInformation/' + this.view.agent + '/' + this.view.provin + '/' + this.view.country+ '/' + this.view.Nameoforganization+ '/' + this.view.Workingtime+ '/' + this.view.Workingday+ '/' + this.view.Addressagency+ '/' + this.view.Contacttime+ '/' + this.view.Inputdataphonenumber+ '/' + this.view.Inputdatafacebook+ '/' + this.view.Inputdataline+ '/' + this.view.Inputdatae_mail,this.view)
         .subscribe(
             data => {
                 console.log('PUT Request is successfully', data);
                 this.router.navigate(['/ComponentNsUiShow']);
             },
             error => {
                  console.log('Rrror', error);
            }
    );
  }
}
