import { Component, OnInit } from '@angular/core';
import { NgxXml2jsonService } from 'ngx-xml2json';
import { environment } from 'src/environments/environment';
import { ProfileServiceService } from '../services/profile-service.service';

@Component({
  selector: 'app-immunization-report',
  templateUrl: './immunization-report.component.html',
  styleUrls: ['./immunization-report.component.css']
})
export class ImmunizationReportComponent implements OnInit {

  constructor(
    private requestService: ProfileServiceService,
    private xml2jsonService: NgxXml2jsonService
  ) { }

  startDate: string = "";
  endDate: string = "";

  ngOnInit(): void {
  }

  generateReport(){
    var response = this.requestService.createReport(this.startDate, this.endDate).subscribe((data: any) => {
      console.log(data);
      window.open(`${environment.serverUrl}/izvestaj${this.startDate}t${this.endDate}`);
    });
  }

}
