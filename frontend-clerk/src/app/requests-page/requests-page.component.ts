import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProfileServiceService } from '../services/profile-service.service';
import { NgxXml2jsonService } from 'ngx-xml2json';

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

  ngOnInit(): void {
    var response = this.requestService.findAllRequests().subscribe((data: any) => {
      console.log(data);
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, 'text/xml');
      const obj: any = this.xml2jsonService.xmlToJson(xml);
      console.log(obj.zahtevi.zahtev[0]);
    })
  }

}
