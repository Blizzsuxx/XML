import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DokumentiService } from 'src/app/services/dokumenti/dokumenti.service';
import { xml2js } from 'xml-js';

@Component({
  selector: 'app-izlistaj-dokumente',
  templateUrl: './izlistaj-dokumente.component.html',
  styleUrls: ['./izlistaj-dokumente.component.css']
})
export class IzlistajDokumenteComponent implements OnInit {

  docs : any;

  constructor(private dokumentiService : DokumentiService, private router : Router) { }


  escapeRegExp(string : string) {
    return string.replace(/[.*+?^${}()|[\]\\]/g, '\\$&'); // $& means the whole matched string
  }
  
  replaceAll(str : string, find : string, replace : string) {
    return str.replace(new RegExp(this.escapeRegExp(find), 'g'), replace);
  }

  unescapeHTML(escapedHTML : string) {
    let val = escapedHTML.replace(/&lt;/g,'<').replace(/&gt;/g,'>').replace(/&amp;/g,'&');
    val = this.replaceAll(val, "<ArrayList>", '');
    val = this.replaceAll(val, "</ArrayList>", '');
    val = this.replaceAll(val, "<item>", '');
    return val;
  }

  

  ngOnInit(): void {
    this.docs = this.dokumentiService.nabaviPodatke().subscribe(data => {
      const data2 = this.unescapeHTML(data);
      let data3 = data2.split('</item>');
      console.log(data3)
      data3.pop();
      console.log(data3)
      this.docs = data3;
      }
    );
  }


  getDoc(doc : any){
    this.dokumentiService.skiniPodatke(doc);
  }

  viewDoc(doc : any){
    this.router.navigate(['/dokument', doc]);
  }

  

}
