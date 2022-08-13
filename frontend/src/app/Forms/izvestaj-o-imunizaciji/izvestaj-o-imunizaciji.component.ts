import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IzvestajOImunizaciji, TDoza, TProizvodjac } from 'src/app/model/izvestaj-o-imunizaciji';
import { DokumentiService } from 'src/app/services/dokumenti/dokumenti.service';

@Component({
  selector: 'app-izvestaj-o-imunizaciji',
  templateUrl: './izvestaj-o-imunizaciji.component.html',
  styleUrls: ['./izvestaj-o-imunizaciji.component.css']
})
export class IzvestajOImunizacijiComponent implements OnInit {

  constructor(
    private datePipe : DatePipe,
    private dokumentiService : DokumentiService
    ) { }

  ngOnInit(): void {
  }
  interesovanja = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  sertifikat = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  izdato = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  doze = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  doze1 = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  doze2 = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  doze3 = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  pfizer = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  sinopharm = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  sputnik = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  astraZeneca = new FormControl('', [Validators.required, Validators.pattern("[0-9]+")]);
  range = new FormGroup({
    datumOd: new FormControl(null),
    datumDo: new FormControl(null),
  });
  
  autofillData(): void {

  }

  submit(): void {

    let datumOd = this.datePipe.transform(this.range.value.datumOd, 'yyyy-MM-dd');
    if (datumOd == null) {
      datumOd = "";
    }
    let datumDo = this.datePipe.transform(this.range.value.datumDo, 'yyyy-MM-dd');
    if(datumDo == null){
      datumDo = "";
    }
    let doze: TDoza[] = [];
    let proizvodjaci: TProizvodjac[] = [];
    doze.push(new TDoza(1, this.doze1.value));
    doze.push(new TDoza(1, this.doze2.value));
    doze.push(new TDoza(1, this.doze3.value));
    proizvodjaci.push(new TProizvodjac("pfizer", this.pfizer.value));
    proizvodjaci.push(new TProizvodjac("sputnik", this.sputnik.value));
    proizvodjaci.push(new TProizvodjac("sinopharm", this.sinopharm.value));
    proizvodjaci.push(new TProizvodjac("astraZeneca", this.astraZeneca.value));
    let izvestaj = new IzvestajOImunizaciji(datumOd, datumDo, this.interesovanja.value, this.sertifikat.value, this.izdato.value, this.doze.value, doze, proizvodjaci);

    console.log(izvestaj);
    this.dokumentiService.sacuvajIzvestajOImunizaciji(izvestaj);

  }

}
