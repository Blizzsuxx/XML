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
      console.log(obj.ZahteviZaSertifikat);
      
      if(Array.isArray(obj.ZahteviZaSertifikat.zahtev.zahtev)){
        this.requests = obj.ZahteviZaSertifikat.zahtev.zahtev;
      }
      else{
        this.requests = Array(obj.ZahteviZaSertifikat.zahtev.zahtev);
      }
      for(let i = 0; i < this.requests.length; i++){
        if( Object.keys(this.requests[i].razlog).length == 0){
          this.requests[i].razlog = "Prazno";
        }
      }
      console.log(this.requests);
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
        req.pacijent.jmbg != jmbg;
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
