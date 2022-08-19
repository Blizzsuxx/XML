import { Component, OnInit } from '@angular/core';
import { NgxXml2jsonService } from 'ngx-xml2json';
import { ProfileServiceService } from '../services/profile-service.service';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
export class SearchPageComponent implements OnInit {

  constructor(
    private requestService: ProfileServiceService,
    private xml2jsonService: NgxXml2jsonService
    ) { }

  sSearch: string = "";

  documents: Array<any> = [];

  ngOnInit(): void {
  }

  handleSearch(){
    this.requestService.simpleSearch(this.sSearch).subscribe((data: any) => {
      console.log(data);
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, 'text/xml');
      const obj: any = this.xml2jsonService.xmlToJson(xml);
      console.log(obj);
      this.documents = obj.documents.sertifikat;
    });
  }

}
