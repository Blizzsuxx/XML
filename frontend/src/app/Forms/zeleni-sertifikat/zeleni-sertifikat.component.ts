import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthentitacionService } from '../../services/autentication/authentitacion.service';//'../../../app//model/service/auth-service/authentication.service';
import { DatePipe } from '@angular/common';
import { ZahtevZaZeleniSertifikat } from 'src/app/model/zahtev-za-zeleni-sertifikat';
import { DokumentiService } from 'src/app/services/dokumenti/dokumenti.service';
@Component({
  selector: 'app-zeleni-sertifikat',
  templateUrl: './zeleni-sertifikat.component.html',
  styleUrls: ['./zeleni-sertifikat.component.css']
})
export class ZeleniSertifikatComponent implements OnInit {

  pol = "";
  richText = "";
  ime= new FormControl(null, [Validators.required]);
  prezime = new FormControl(null, [Validators.required]);
  rodjendan = new FormControl(null, [Validators.required]);
  jmbg = new FormControl(null, [Validators.required, Validators.pattern("[0-9]{13}")]);
  pasos = new FormControl(null, [Validators.required, Validators.pattern("[0-9]{10}")]);
  mesto = new FormControl(null, [Validators.required]);

  constructor(
    public router: Router,
    private dokumentiService: DokumentiService,
    private datePipe: DatePipe
  ) { }

  ngOnInit() {
      
  }
  getErrorMessage() {
    if (this.ime.hasError('required')) {
      return 'Morate da uneste ime';
    }

    return this.ime.hasError('ime') ? 'nije validno ime' : '';
  }
  signup() {
    let rodjendan = this.datePipe.transform(this.rodjendan.value, 'yyyy-MM-dd');
    if(rodjendan == null){
      rodjendan = "";
    }
    console.log(this.richText);  
    const zahtev = new ZahtevZaZeleniSertifikat(this.jmbg.value, this.ime.value, this.prezime.value,
      this.pol, rodjendan, this.mesto.value, this.richText, this.pasos.value)
    
      this.dokumentiService.sacuvajZahtevZaZeleniSertifikat(zahtev);
  }

}
