import { Component, OnInit } from '@angular/core';
import { VaccineService } from '../services/vaccine.service';
import { NgxXml2jsonService } from 'ngx-xml2json';

@Component({
  selector: 'app-vaccines-page',
  templateUrl: './vaccines-page.component.html',
  styleUrls: ['./vaccines-page.component.css']
})
export class VaccinesPageComponent implements OnInit {

  constructor(
    private requestService: VaccineService,
    private xml2jsonService: NgxXml2jsonService) { }

  id: number = 1;
  manufacturer: string = "";
  quantity: number = 0;
  vaccines: Array<any> = [];

  newQuantity: number = 0;

  ngOnInit(): void {
    var response = this.requestService.findAllVaccines().subscribe((data: any) => {
      console.log(data);
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, 'text/xml');
      const obj: any = this.xml2jsonService.xmlToJson(xml);
      console.log(obj.vaccines);
      this.vaccines = obj.vaccines.vaccine;
    })
  }

  saveVaccine(){
    console.log(this.id, this.manufacturer, this.quantity);
    var response = this.requestService.saveVaccineXml(this.id, this.manufacturer, this.quantity).subscribe((data: any) => {
      console.log(data);
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, 'text/xml');
      const obj: any = this.xml2jsonService.xmlToJson(xml);
      console.log(obj.vaccine);
    })
  }

  updateQuantity(vaccineId: number){
    var response = this.requestService.updateQuantity(vaccineId, this.newQuantity).subscribe((data:any) => {
      this.vaccines.map(vacc => {
        if(vacc.id == vaccineId){
          vacc.quantity = this.newQuantity;
        }
      })
    });
  }

}
