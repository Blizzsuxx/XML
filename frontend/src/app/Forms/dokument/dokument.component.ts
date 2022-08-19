import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DokumentiService } from 'src/app/services/dokumenti/dokumenti.service';

@Component({
  selector: 'app-dokument',
  templateUrl: './dokument.component.html',
  styleUrls: ['./dokument.component.css']
})
export class DokumentComponent implements OnInit {

  constructor(private dokumentService : DokumentiService, private activatedRoute : ActivatedRoute) { }
  dokument : any;
  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      const type = params['type'];
      console.log(type);
      this.dokumentService.getDokument(type).subscribe((data: any) => {
        this.dokument = data;
        console.log(this.dokument);
      });
      });
    
  }

}
