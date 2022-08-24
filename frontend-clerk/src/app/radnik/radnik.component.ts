import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ProfileServiceService } from '../services/profile-service.service';
import { NgxXml2jsonService } from 'ngx-xml2json';
import { environment } from 'src/environments/environment';
import { Evidencija, Kolona } from '../model/kolona';

@Component({
  selector: 'app-radnik',
  templateUrl: './radnik.component.html',
  styleUrls: ['./radnik.component.css']
})
export class RadnikComponent implements OnInit {

  constructor(
    public router: Router,
    private requestService: ProfileServiceService,
    private xml2jsonService: NgxXml2jsonService
  ) { }

  selectedJmbg: string = "";
  institution: string = "";
  name: string = "";
  lastname: string = "";
  punkt: string = "";
  faksimil: string = "";
  telephone: string = "";
  privremeneKontradikcije: string = "";
  privremeneKontradikcijeDatum: string = "";
  trajneKontradikcije: boolean = false;
  tabela: Array<Kolona> = [];
  saglasnost: any = null;

  ngOnInit(): void {
    this.tabela.push(new Kolona());
    this.tabela.push(new Kolona());
    this.privremeneKontradikcijeDatum = new Date().toISOString().substring(0, 10);
    this.tabela[0].datumVakcine = new Date().toISOString().substring(0, 10);
    this.tabela[1].datumVakcine = new Date().toISOString().substring(0, 10);
  }

  showAccordance() {
    var response = this.requestService.showDocument("saglasnost", this.selectedJmbg).subscribe((data: any) => {
      console.log(data);

      window.open(`${environment.serverUrl}/${data}`);
    });
  }

  vaccinate() {
    var response = this.requestService.getSaglasnostDokument(this.selectedJmbg).subscribe((data: any) => {
      console.log(data);
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, 'text/xml');
      const obj: any = this.xml2jsonService.xmlToJson(xml);
      console.log(obj.Dokument.saglasnostZaSprovodjenjeImunizacije.izjava.saglasnost.izabran == "true");
      if (obj.Dokument.saglasnostZaSprovodjenjeImunizacije.izjava.saglasnost.izabran == "true") {
        this.saglasnost = obj.Dokument;
        console.log(this.saglasnost);
        if (this.saglasnost.evidencijaOVakcinaciji.tabela != null && this.saglasnost.evidencijaOVakcinaciji.tabela != undefined) {

          if (this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije != null && this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije != undefined
            && this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije.datum != null) {
            this.privremeneKontradikcijeDatum = this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije.datum;
          }
          if (this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije != null && this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije != undefined
            && this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije.dijagnoza != null) {

            this.privremeneKontradikcije = this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije.dijagnoza;
          }

        }

        this.tabela[0].nazivVakcine = this.getVaccine(obj.Dokument.saglasnostZaSprovodjenjeImunizacije.izjava.vakcina);
        this.tabela[0].proizvodjac = this.getVaccine(obj.Dokument.saglasnostZaSprovodjenjeImunizacije.izjava.vakcina);
        this.tabela[1].nazivVakcine = this.getVaccine(obj.Dokument.saglasnostZaSprovodjenjeImunizacije.izjava.vakcina);
        this.tabela[1].proizvodjac = this.getVaccine(obj.Dokument.saglasnostZaSprovodjenjeImunizacije.izjava.vakcina);

        if (this.saglasnost.evidencijaOVakcinaciji.trajneKontradikcije != undefined) {
          this.trajneKontradikcije = this.saglasnost.evidencijaOVakcinaciji.tabela.trajneKontradikcije.izabran;
          this.privremeneKontradikcije = this.saglasnost.evidencijaOVakcinaciji.tabela.privremeneKontradikcije;
          for (let i = 0; i < this.saglasnost.evidencijaOVakcinaciji.tabela.element.length; i++) {
            this.tabela[i].datumVakcine = this.saglasnost.evidencijaOVakcinaciji.tabela.element[i].datumDavanja;
            this.tabela[i].ekstremitet = this.saglasnost.evidencijaOVakcinaciji.tabela.element[i].ekstremitet;
            this.tabela[i].serija = this.saglasnost.evidencijaOVakcinaciji.tabela.element[i].serija;
            this.tabela[i].proizvodjac = this.saglasnost.evidencijaOVakcinaciji.tabela.element[i].proizvodjac;
            this.tabela[i].nezeljenaReakcija = this.saglasnost.evidencijaOVakcinaciji.tabela.element[i].nezeljenaReakcija;
            this.tabela[i].potpisLekara = this.saglasnost.evidencijaOVakcinaciji.tabela.element[i].potpisLekara;
            this.tabela[i].nazivVakcine = this.saglasnost.evidencijaOVakcinaciji.tabela.element[i].vakcina;
          }
        }
      }
      console.log(obj);
    });
  }

  isEmpty(obj: any) {
    return Object.keys(obj).length === 0;
  }

  isNotEmpty(obj: any) {
    return !(Object.keys(obj).length === 0);
  }

  getVaccine(vaccine: any) {
    if (this.isNotEmpty(vaccine.astraZeneca)) {
      return vaccine.astraZeneca;
    } else if (this.isNotEmpty(vaccine.moderna)) {
      return vaccine.moderna;
    } else if (this.isNotEmpty(vaccine.pfizer)) {
      return vaccine.pfizer;
    } else if (this.isNotEmpty(vaccine.sinopharm)) {
      return vaccine.sinopharm;
    } else if (this.isNotEmpty(vaccine.sputnik)) {
      return vaccine.sputnik;
    }
    return "";
  }

  submit() {
    let evidencija = new Evidencija();
    evidencija.telephone = this.telephone;
    evidencija.faksimil = this.faksimil;
    evidencija.name = this.name;
    evidencija.lastname = this.lastname;
    evidencija.tabela.kolona = this.tabela;
    evidencija.punkt = this.punkt;
    evidencija.institution = this.institution;
    evidencija.trajneKontradikcije = this.trajneKontradikcije;
    evidencija.privremeneKontradikcije = this.privremeneKontradikcije;
    evidencija.privremeneKontradikcijeDatum = this.privremeneKontradikcijeDatum;


    this.requestService.sendEvidencija(evidencija, this.selectedJmbg).subscribe((data: any) => {
      console.log(data);
    });

  }
}
