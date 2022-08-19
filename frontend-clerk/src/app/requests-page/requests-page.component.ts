import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ProfileServiceService } from '../services/profile-service.service';
import { NgxXml2jsonService } from 'ngx-xml2json';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-requests-page',
  templateUrl: './requests-page.component.html',
  styleUrls: ['./requests-page.component.css']
})
export class RequestsPageComponent implements OnInit {

  constructor(
    public router: Router,
    private requestService: ProfileServiceService,
    private xml2jsonService: NgxXml2jsonService
  ) { }

  requests: Array<any> = [];
  
  reason: string = "";

  selectedJmbg: string = "";
  documents: any;

  ngOnInit(): void {
    var response = this.requestService.findAllRequests().subscribe((data: any) => {
      console.log(data);
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, 'text/xml');
      const obj: any = this.xml2jsonService.xmlToJson(xml);
      console.log(obj);
      console.log(Array.isArray(obj.zahtevi.zahtev));
      
      if(Array.isArray(obj.zahtevi.zahtev)){
        this.requests = obj.zahtevi.zahtev;
      }
      else{
        this.requests = Array(obj.zahtevi.zahtev);
      }
      
    });
  }

  showDocumentation(jmbg: string){
    console.log("Showing documentation for citizen: " + jmbg);
    this.selectedJmbg = jmbg;

    var response = this.requestService.findAllCitizenDocuments(jmbg).subscribe((data: any) => {
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, 'text/xml');
      const obj: any = this.xml2jsonService.xmlToJson(xml);
      console.log(obj);
    });
  }

  acceptRequest(jmbg: string){
    var response = this.requestService.acceptCertificateRequest(jmbg).subscribe((data: any) => {
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, 'text/xml');
      const obj: any = this.xml2jsonService.xmlToJson(xml);
      console.log(obj);
      // alert("User received an email containing generated digital certificate!");
      this.requests = this.requests.filter(req => { 
        req.Pacijent.jmbg != jmbg;
      });
      window.open(`${environment.serverUrl}/digitalcert${obj.digitalniSertifikat['@attributes'].ID}`);

    });
  }

  declineRequest(jmbg: string){
    var response = this.requestService.declineCertificateRequest(jmbg, this.reason).subscribe((data: any) => {
      console.log(data);
    });
  }


  showRequest(){
    var response = this.requestService.showDocument("request", this.selectedJmbg).subscribe((data: any) => {
      console.log(data);
      
      window.open(`${environment.serverUrl}/${data}`);
    });
  }
  
  showAccordance(){
    var response = this.requestService.showDocument("saglasnost", this.selectedJmbg).subscribe((data: any) => {
      console.log(data);
      
      window.open(`${environment.serverUrl}/${data}`);
    }); 
  }

  showVaccination(){
    this.requestService.showDocument("potvrda", this.selectedJmbg).subscribe((data: any) => {
      console.log(data);
      window.open(`${environment.serverUrl}/${data}`);
    });
  }
}
